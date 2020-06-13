package pjatk.project.Model;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PriceValidator.class)
@Target(ElementType.FIELD)
public @interface Price {
    String message() default "This product has no price";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
