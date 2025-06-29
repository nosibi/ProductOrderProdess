package com.OrderProcess.configuration.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GradeValidator implements ConstraintValidator<Grade, com.OrderProcess.data.Grade> {
    @Override
    public boolean isValid(com.OrderProcess.data.Grade grade, ConstraintValidatorContext constraintValidatorContext) {
        if(grade != com.OrderProcess.data.Grade.GOLD && grade != com.OrderProcess.data.Grade.SILVER && grade != com.OrderProcess.data.Grade.BRONZE){
            return false;
        }
        return true;
    }
}
