package pjatk.project.Model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PriceValidator implements ConstraintValidator<Price, Double> {
    @Override
    public void initialize(Price Price) {}

    @Override
    public boolean isValid(Double price, ConstraintValidatorContext constraintValidatorContext) {
        return price != null;
    }
}
