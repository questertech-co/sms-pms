package com.quester.schoolmanagementsystem.payments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PaymentDto {
    private Long studentId;
    private Double amountReceived;
    private Long paymentTermId;
}
