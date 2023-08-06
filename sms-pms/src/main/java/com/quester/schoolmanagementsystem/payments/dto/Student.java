package com.quester.schoolmanagementsystem.payments.dto;

import lombok.Getter;

@Getter
public class Student {
    private Long id;
    private Long payingTermId;
    private String firstName;
    private String middleName;
    private String lastName;
    private Form form;
}
