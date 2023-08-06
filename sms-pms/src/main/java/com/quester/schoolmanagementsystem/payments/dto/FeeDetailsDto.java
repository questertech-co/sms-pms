package com.quester.schoolmanagementsystem.payments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class FeeDetailsDto {
    private final Long termId;
    private Double feeAmount;
}
