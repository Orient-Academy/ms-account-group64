package az.edu.orient.msaccount.account.controller;

import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.model.AccountResponse;
import az.edu.orient.msaccount.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("accounts")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountResponse> getAccounts(){
        return accountService.getAccounts();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse getAccountById(@PathVariable("id") Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AccountResponse addAccount(@RequestBody AccountCreateRequest accountCreateRequest){
        return accountService.addAccount(accountCreateRequest);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AccountResponse updateAccount(@PathVariable Long id,@RequestBody AccountCreateRequest accountCreateRequest){
        return accountService.updateAccount(id,accountCreateRequest);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteAccount(@PathVariable("id") Long id){
        accountService.deleteAccount(id);
    }

}
