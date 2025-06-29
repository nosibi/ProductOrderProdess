package com.OrderProcess.configuration.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = NameValidator.class)
public @interface Name {
    String message() default "이름은 2자 이상 9자 이하이어야 합니다.";
    Class<?>[] groups() default{};
    Class<? extends Payload>[] payload() default {};
}
