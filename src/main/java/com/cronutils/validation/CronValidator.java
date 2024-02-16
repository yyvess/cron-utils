package com.cronutils.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CronValidator extends AbstractCronValidator implements ConstraintValidator<Cron, String> {


    @Override
    public void initialize(Cron constraintAnnotation) {
        super.initialize(constraintAnnotation.type());
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        try {
            return super.isValid(value);
        } catch (IllegalArgumentException e) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addConstraintViolation();
            return false;
        }
    }
}
