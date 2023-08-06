package com.quester.schoolmanagementsystem.payments.dto;

public class FeeDetail {
    private Long studentId;
    private String studentFistName;
    private String studentMiddleName;
    private String studentLastName;
    private Double maxAmount;

    private Double mostRecentFeePaymentForATerm;
    public
    FeeDetail(Long studentId, String studentFistName, String studentMiddleName, String studentLastName, Double amountToBePaid,Double amountPaid) {
        this.studentId = studentId;
        this.studentFistName = studentFistName;
        this.studentMiddleName =studentMiddleName;
        this.maxAmount = amountToBePaid;
        this.mostRecentFeePaymentForATerm =amountPaid;
    }
}
