package com.quester.schoolmanagementsystem.payments.service;

/*import com.quester.schoolmanagementsystem.payments.dto.Student;
import com.quester.schoolmanagementsystem.payments.dto.Term;
import com.quester.schoolmanagementsystem.payments.dto.TheSession;
import com.quester.schoolmanagementsystem.payments.entity.DueFee;
import com.quester.schoolmanagementsystem.payments.dto.FeeDetail;
import com.quester.schoolmanagementsystem.payments.dto.DueFeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import com.quester.schoolmanagementsystem.payments.repository.DueFeeRepository;*/
import com.quester.schoolmanagementsystem.payments.OpenFeign.RegistryClient;
import com.quester.schoolmanagementsystem.payments.dto.FeeDetail;
import com.quester.schoolmanagementsystem.payments.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*import java.util.ArrayList;
import java.util.List;*/
@Service
public class FeeService {
    private final RegistryClient client;

    @Autowired
    public FeeService(RegistryClient client) {
        this.client = client;
    }

    public List<FeeDetail> getStudentsOfAParentFeeDetails(Long parentId) {
        ResponseEntity<Set<Student>> studentsResponse = client.getStudentsByParent(parentId);
        Set<Student> students = studentsResponse.getBody();
        List <FeeDetail>feeDetailsOfStudentsOfOneParent = new ArrayList<>();
        return  feeDetailsOfStudentsOfOneParent;
}
  /*  @Autowired
    public DueFeeRepository repository;
    private FeeDetail populateFeeDetails(Student student){
        Long payingTermId = student.getPayingTermId();
        Long formId = student.getForm().getId();
        Long studentId = student.getId();
        DueFee payingTermDetailsObject = repository.findByStudentIdAndPaymentTermId(studentId,payingTermId);
        List <TheSession> sessionsWithIncompletePayments = sessionClient.getIncompletePaymentSessions(payingTermId);
        Double amountPaid = payingTermDetailsObject.getAmountAlreadyPaid();
        Double amountToBePaid = payingTermDetailsObject.getTotalAmount() - payingTermDetailsObject.getAmountAlreadyPaid();
        int size = sessionsWithIncompletePayments.size();
        for(int i=0;i<size;i++){
            TheSession session = sessionsWithIncompletePayments.get(i);
            List <Term> terms = session.getTerms();
            int termSize = terms.size();
            for (int j= 0;j<termSize;j++){
                Term term = terms.get(j);
                if(term.getId() == payingTermId){
                    continue;
                }
                Long termId = term.getId();
                amountToBePaid += termClient.getTermAmount(termId,formId);
            }
        }
        String studentFistName = student.getFirstName();
        String studentMiddleName = student.getMiddleName();
        String studentLastName = student.getLastName();

        FeeDetail feeDetail =
                new FeeDetail(studentId,studentFistName,studentMiddleName,studentLastName,amountToBePaid,amountPaid);
        return feeDetail;
    }
    public List <FeeDetail> getStudentsFeeDetails(Long id){
        List<Student> students = parentClient.getStudents(id);
        List <FeeDetail> studentsFeeDetails = new ArrayList<FeeDetail>();
        int size = students.size();
        for(int i = 0;i<size;i++){
            Student student =  students.get(i);
            FeeDetail feeDetail = populateFeeDetails(student);
            studentsFeeDetails.add(feeDetail);
        }
    }
    private void payFees(DueFeeDto dueFeeDto){
        Long studentId = dueFeeDto.getStudentId();
        Long paymentTermId = dueFeeDto.getPayingTermId();
        Double paymentAmount = dueFeeDto.getAmountRecieved();
        DueFee dueFee = repository.findByPaymentTermIdAndStudentId(paymentTermId,studentId);
        Double remainingAmountForTheTerm = dueFee.getTotalAmount() - dueFee.getAmountAlreadyPaid();
        if (paymentAmount >= remainingAmountForTheTerm){
            Double surplusPayment = paymentAmount - remainingAmountForTheTerm;
            Long newPaymentTermId = termClient.updatePaymentTerm(paymentTermId,studentId);
            Double newAmount = feeClient.getTermAmount(paymentTermId);
            if (surplusPayment >= newAmount){
                DueFee newDueFees = new DueFee(studentId,newAmount,newAmount,newPaymentTermId);
                surplusPayment-=newAmount;
                dueFeeDto.setAmountRecieved(surplusPayment);
                payFees(dueFeeDto);
            }
            else{
                DueFee newDueFee = new DueFee(studentId,newAmount,surplusPayment,newPaymentTermId);
                //add timestamp to payment;
            }
        }
        else{
            dueFee.setAmountAlreadyPaid(totalAmount);
        }

    }*/


}
