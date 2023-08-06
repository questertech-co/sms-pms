package com.quester.schoolmanagementsystem.payments.repository;


import com.quester.schoolmanagementsystem.payments.entity.PaidFeeDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface FeeRepository extends MongoRepository<PaidFeeDetails,Long> {
    PaidFeeDetails findByStudentIdAndPaymentTermId(Long studentId,Long PaymentTermId);
}

