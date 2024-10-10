package az.edu.orient.msaccount.account.validation;

import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class AccountCreateValidation implements Validator {

    private final AccountRepository accountRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return AccountCreateRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountCreateRequest accountCreateRequest = (AccountCreateRequest) target;
        if (accountRepository.findByCurrency(accountCreateRequest.getCurrency()).isPresent()){
            errors.rejectValue("currency","","Currency already exists");
        }
    }
}
