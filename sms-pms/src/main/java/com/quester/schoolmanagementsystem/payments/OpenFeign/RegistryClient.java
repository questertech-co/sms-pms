package com.quester.schoolmanagementsystem.payments.OpenFeign;

import com.quester.schoolmanagementsystem.payments.dto.Student;
import org.bouncycastle.math.ec.custom.sec.SecT113Field;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;

import java.util.Set;

//@FeignClient( url = "http://localhost:8082")
public interface RegistryClient {
    ResponseEntity<Set<Student>> getStudentsByParent(Long parentId);
}
