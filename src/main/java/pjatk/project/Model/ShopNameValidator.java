package pjatk.project.Model;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ShopNameValidator implements ConstraintValidator<ShopName, String> {
    @Override
    public void initialize(ShopName ShopName) {}

    @Override
    public boolean isValid(String shopName, ConstraintValidatorContext constraintValidatorContext) {
        if (shopName.length() < 6) { return false; }
        else {
            char[] chars = shopName.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    return false;
                }
            }
            return true;
        }
    }
}
