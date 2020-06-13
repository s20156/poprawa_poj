package pjatk.project;

import pjatk.project.Model.Product;
import pjatk.project.Model.Shop;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Shop shop = new Shop(1,"5asec");

        Product beer = new Product(1, "Beer", null);
        Product snack = new Product(2, "Snack", 1.29);

        System.out.println(snack);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Product>> validatePrice = validator.validate(beer);
        System.out.println(validatePrice);

        Validator validateShopName = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Shop>> validateName = validateShopName.validate(shop);
        System.out.println(validateName);
    }
}
