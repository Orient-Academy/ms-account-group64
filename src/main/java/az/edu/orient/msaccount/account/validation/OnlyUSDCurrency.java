package az.edu.orient.msaccount.account.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = OnlyUSDCurrencyValidator.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface OnlyUSDCurrency {
    String message() default "Invalid currency";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
 }
