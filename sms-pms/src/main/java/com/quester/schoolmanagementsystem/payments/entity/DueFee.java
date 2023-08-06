package com.quester.schoolmanagementsystem.payments.entity;

import lombok.Getter;
import lombok.Setter;


/*import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;*/
import java.util.Date;

@Getter
@Setter
public class DueFee {
    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)*/
    private Long id;
    private String name;
    private Long studentId;
    private Date LastDatePaid;
    private Double amountAlreadyPaid;
    private Double totalAmount;
    private Double newAmount;


    public DueFee(Long studentId, Double newAmount, Double totalAmount, Long newPaymentTermId) {
    }
}
