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
        AccountCreateRequest request = new AccountCreateRequest();
        request.setName("Nemet");
        request.setCurrency(Currency.USD);
        request.setBalance(BigDecimal.valueOf(500));

        AccountEntity accountEntity = new AccountEntity();
        accountEntity.setName(request.getName());
        accountEntity.setCurrency(request.getCurrency());
        accountEntity.setBalance(request.getBalance());

        when(mapper.toEntity(request)).thenReturn(accountEntity);
        when(accountRepository.save(any(AccountEntity.class))).thenAnswer(invocation -> {
            AccountEntity savedEntity = invocation.getArgument(0);
            savedEntity.setId(1L);
            return savedEntity;
        });

        AccountResponse expectedResponse = new AccountResponse();
        expectedResponse.setId(1L);
        expectedResponse.setName(request.getName());
        expectedResponse.setIban(UUID.randomUUID().toString());
        expectedResponse.setStatus(Status.ACTIVE);

        when(mapper.toResponse(any(AccountEntity.class))).thenReturn(expectedResponse);

        AccountResponse response = accountService.addAccount(request);

        assertNotNull(response);
        assertEquals(1L, response.getId());
        assertEquals(request.getName(), response.getName());
        assertEquals(Status.ACTIVE, response.getStatus());

        verify(mapper).toEntity(request);
        verify(accountRepository).save(accountEntity);
        verify(mapper).toResponse(any(AccountEntity.class));

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