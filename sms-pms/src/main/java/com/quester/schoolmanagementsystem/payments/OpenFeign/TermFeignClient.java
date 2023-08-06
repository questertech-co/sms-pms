package com.quester.schoolmanagementsystem.payments.OpenFeign;

import com.quester.schoolmanagementsystem.payments.dto.FeeDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("registry-service")
public interface TermFeignClient {
    @GetMapping("/next-term-fee-details")
    FeeDetailsDto getNextTermFeeDetails(Long studentId, Long termId);
}
