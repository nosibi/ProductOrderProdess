package com.OrderProcess.configuration.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = GradeValidator.class)
public @interface Grade {
    String message() default "회원 등급은 GOLD,SILVER,BRONZE 중에서 선택";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
