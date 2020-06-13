package pjatk.project;

import pjatk.project.Controller.ShopService;
import pjatk.project.Model.Customer;
import pjatk.project.Model.Product;
import pjatk.project.Model.Shop;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        Product beer = new Product(1, "Beer", 0.99);
        Product snack = new Product(2, "Snack", 1.29);

        Shop shop = new Shop(1,"Carrefour", new ArrayList<Product>(Arrays.asList(beer, snack)), new ArrayList<Product>(), new ArrayList<Customer>());

        Customer test = new Customer(1, new ArrayList<Product>(Arrays.asList(beer)));

        System.out.println(snack);

        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Product>> validatePrice = validator.validate(beer);
        System.out.println(validatePrice);

        Validator validateShopName = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Shop>> validateName = validateShopName.validate(shop);
        System.out.println(validateName);
    }
}
