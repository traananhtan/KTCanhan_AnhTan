//package com.example.demo.validator.annotation;
//
//import com.example.demo.validator.ValidPhongbanIdValidator;
//import jakarta.validation.Constraint;
//import jakarta.validation.Payload;
//
//import java.lang.annotation.*;
//
//@Target({ElementType.TYPE,ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy = ValidPhongbanIdValidator.class)
//@Documented
//
//public interface Validphongbanid {
//String message()default "Invalid Phongban ID";
//Class<?[] groups() default{};
//Class<?  extends Payload>[] payload()default{};
//
//}
