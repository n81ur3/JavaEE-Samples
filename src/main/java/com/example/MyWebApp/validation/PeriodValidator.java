package com.example.MyWebApp.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PeriodValidator implements ConstraintValidator<PeriodConstraint, Period> {

    @Override
    public boolean isValid(Period period, ConstraintValidatorContext constraintValidatorContext) {
        return period.getStartDate().before(period.getEndDate());
    }
}
