package az.edu.orient.msaccount.account.validation;

import az.edu.orient.msaccount.account.model.Currency;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class OnlyUSDCurrencyValidator implements ConstraintValidator<OnlyUSDCurrency, Currency> {
    @Override
    public void initialize(OnlyUSDCurrency constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Currency currency, ConstraintValidatorContext constraintValidatorContext) {
        return Currency.USD.equals(currency);
    }
}
