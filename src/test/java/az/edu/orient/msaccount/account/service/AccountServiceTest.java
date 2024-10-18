package az.edu.orient.msaccount.account.service;

import az.edu.orient.msaccount.account.entity.AccountEntity;
import az.edu.orient.msaccount.account.mapper.AccountMapper;
import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.model.AccountResponse;
import az.edu.orient.msaccount.account.model.Currency;
import az.edu.orient.msaccount.account.model.Status;
import az.edu.orient.msaccount.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {
    @Mock
    AccountRepository accountRepository;
    @Mock
    AccountMapper mapper;
    @InjectMocks
    AccountService accountService;

    @Test
    void addAccount() {
    }

    @Test
    void updateAccount() {

    }

    @Test
    void getAccounts() {
    }

    @Test
    void getAccountById() {
    }

    @Test
    void deleteAccount() {
        Long id = 1L;
        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setId(id);
        accountEntity.setStatus(Status.ACTIVE);
        when(accountRepository.findAccountEntitiesById(Mockito.anyLong())).thenReturn(accountEntity);
        accountService.deleteAccount(id);
        verify(accountRepository, times(1)).findAccountEntitiesById(id);
        verify(accountRepository, times(1)).save(accountEntity);
        assert (accountEntity.getStatus() == Status.INACTIVE);
    }
}