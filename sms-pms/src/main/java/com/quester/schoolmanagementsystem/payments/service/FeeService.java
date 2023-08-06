package com.quester.schoolmanagementsystem.payments.service;

import com.quester.schoolmanagementsystem.payments.OpenFeign.TermFeignClient;
import com.quester.schoolmanagementsystem.payments.dto.FeeDetailsDto;
import com.quester.schoolmanagementsystem.payments.dto.PaymentDto;
import com.quester.schoolmanagementsystem.payments.entity.PaidFeeDetails;
import com.quester.schoolmanagementsystem.payments.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.Date;

import java.util.Set;

@Service
public class FeeService {
    private final FeeRepository repository;
    private final TermFeignClient termFeignClient;
    @Autowired
    public FeeService(FeeRepository repository, TermFeignClient termFeignClient) {
        this.repository = repository;
        this.termFeignClient = termFeignClient;
    }
    public ResponseEntity<String> payFees(Set<PaymentDto> paymentDtoS) {
        try {
            for (PaymentDto paymentDto : paymentDtoS) {
                Date recentPaymentDate = new Date();
                Long studentId = paymentDto.getStudentId();
                Long termId = paymentDto.getPaymentTermId();
                Double amountReceived = paymentDto.getAmountReceived();
                PaidFeeDetails payingTermDetails = repository.findByStudentIdAndPaymentTermId(studentId, termId);
                Double amountPaid = payingTermDetails.getAmountPaid();
                Double totalTermFeePayable = payingTermDetails.getTotalAmountPayable();
                Double totalAmountReceived = amountPaid + amountReceived;
                if (totalAmountReceived >= totalTermFeePayable) {
                    payingTermDetails.setAmountPaid(totalTermFeePayable);
                    payingTermDetails.setRecentPaymentDate(recentPaymentDate);
                    repository.save(payingTermDetails);
                    Double excessAmount = totalAmountReceived - totalTermFeePayable;
                    payNextTerm(termId, excessAmount, studentId, recentPaymentDate);
                } else {
                    payingTermDetails.setAmountPaid(totalAmountReceived);
                    payingTermDetails.setRecentPaymentDate(new Date());
                    repository.save(payingTermDetails);
                }
            }
            String response = "payment successful";
            return new ResponseEntity<>(response, HttpStatus.OK);

        } catch (NullPointerException error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    public void payNextTerm(Long termId, Double amountReceived, Long studentId, Date recentPaymentDate) {
        FeeDetailsDto nextTermFeeDetails = termFeignClient.getNextTermFeeDetails(studentId, termId);
        Double totalPayableFee = nextTermFeeDetails.getFeeAmount();

        if (amountReceived >= totalPayableFee) {
            Double excessAmount = amountReceived - totalPayableFee;
            PaidFeeDetails newPaymentDetails = new PaidFeeDetails(studentId, termId, totalPayableFee, recentPaymentDate, totalPayableFee);
            repository.save(newPaymentDetails);
            payNextTerm(nextTermFeeDetails.getTermId(), excessAmount, studentId, recentPaymentDate);
        } else {
            PaidFeeDetails newPaymentDetails = new PaidFeeDetails(studentId, termId, amountReceived, recentPaymentDate, totalPayableFee);
            repository.save(newPaymentDetails);
        }
    }
}


