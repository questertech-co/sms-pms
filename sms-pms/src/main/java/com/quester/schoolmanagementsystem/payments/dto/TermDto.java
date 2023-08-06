package com.quester.schoolmanagementsystem.payments.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TermDto {
    private Long id;
    private Double totalAmountPayable;
}
