package com.quester.schoolmanagementsystem.payments.controller;


import com.quester.schoolmanagementsystem.payments.dto.PaymentDto;
import com.quester.schoolmanagementsystem.payments.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
public class FeesController {
    private final FeeService feeService;
    @Autowired
    public FeesController(FeeService feeService) {
        this.feeService = feeService;
    }
    @GetMapping("/")
    public String hello(){
        return "hello from payment service";
    }

    @PostMapping("/pay-fees")
    public ResponseEntity<String> payFees(@RequestBody Set<PaymentDto> paymentDtoS){
        return feeService.payFees(paymentDtoS);

    }

  /*@GetMapping("/{parentId}")
  @Autowired
    public List<FeeDetail> getStudentsFeeDetails(@PathVariable Long parentId, FeeService service){
    return service.getStudentsOfAParentFeeDetails(parentId);
    }*/


    //@GetMapping("/paid")
    //get all payments for all time

    //@GetMapping("/{termId}/unpaid")
    //get all unpaid for a particular term

    //@GetMapping("/unpaid")
    //get all unpaid fees for all time

    //@PatchMapping("/")

    // pay fees per student

    //@PatchMapping("/{parentId}")
    // pay fee via autodebit

    //@GetMapping("/{studentId}")
    // get student all time payment history

    //@GetMapping("/{studentId}/termId")
    // get student  payment for a term
}
