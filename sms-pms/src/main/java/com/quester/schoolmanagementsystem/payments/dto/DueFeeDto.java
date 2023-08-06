package com.quester.schoolmanagementsystem.payments.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DueFeeDto {
    private Long studentId;
    private Long payingTermId;
    private String firstName;
    private String middleName;
    private String surName;
    private Double amountLeftToBePaid;
    private Boolean canOverPay;
    private Double amountPaid;
}
