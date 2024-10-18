package az.edu.orient.msaccount.account.validation;

import az.edu.orient.msaccount.account.model.Currency;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OnlyUSDCurrencyValidatorTest {

    OnlyUSDCurrencyValidator validator = new OnlyUSDCurrencyValidator();

    @Test
    void isValidWhenCurrencyIsUSDThenReturnTrue(){
        //setup
        Currency currency= Currency.USD;
        //when
        var result = validator.isValid(currency,null);
        //expect
        assertTrue(result);
    }

    @Test
    void isValidWhenCurrencyIsNullThenReturnFalse(){
        //setup
        Currency currency= null;
        //when
        var result = validator.isValid(currency,null);
        //expect
        assertFalse(result);
    }
    @Test
    void isValidWhenCurrencyIsNotUSDThenReturnFalse(){
        //setup
        Currency currency= Currency.AZN;
        //when
        var result = validator.isValid(currency,null);
        //expect
        assertFalse(result);
    }
}
