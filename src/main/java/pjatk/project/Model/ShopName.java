package pjatk.project.Model;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ShopNameValidator.class)
@Target(ElementType.FIELD)
public @interface ShopName {
    String message() default "Invalid Shop Name";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
