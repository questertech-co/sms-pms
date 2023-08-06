package com.quester.schoolmanagementsystem.payments.controller;


import com.quester.schoolmanagementsystem.payments.dto.FeeDetail;
import com.quester.schoolmanagementsystem.payments.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FeesController {


    @GetMapping("/")
    public String hello(){
        return "hello from payment service";
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
