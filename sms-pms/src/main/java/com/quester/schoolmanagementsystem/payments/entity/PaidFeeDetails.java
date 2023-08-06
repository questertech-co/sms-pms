package com.quester.schoolmanagementsystem.payments.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import java.util.Date;

@Getter
@Setter
@Document(collection = "paid-fees")
public class PaidFeeDetails {
    @Id
    private Long id;
    private final Long studentId;
    private final Long paymentTermId;
    private Double amountPaid;
    private Date recentPaymentDate;
    private Double totalAmountPayable;
    public PaidFeeDetails(Long studentId, Long paymentTermId, Double amountPaid, Date recentPaymentDate, Double totalAmountPayable) {
    this.studentId = studentId;
    this.paymentTermId = paymentTermId;
    this.amountPaid = amountPaid;
    this.recentPaymentDate = recentPaymentDate;
    this.totalAmountPayable = totalAmountPayable;

    }
}
