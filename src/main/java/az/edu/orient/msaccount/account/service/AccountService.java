package az.edu.orient.msaccount.account.service;

import az.edu.orient.msaccount.account.entity.AccountEntity;
import az.edu.orient.msaccount.account.mapper.AccountMapper;
import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.model.AccountResponse;
import az.edu.orient.msaccount.account.model.Status;
import az.edu.orient.msaccount.account.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final AccountMapper mapper;

    public AccountResponse addAccount(AccountCreateRequest request) {
        AccountEntity entity = mapper.toEntity(request);
        entity.setIban(UUID.randomUUID().toString());
        entity.setStatus(Status.ACTIVE);
        AccountEntity saved = accountRepository.save(entity);
        return mapper.toResponse(saved);
    }

    public AccountResponse updateAccount(Long id,AccountCreateRequest request){
        AccountEntity entity = accountRepository.findAccountEntitiesById(id);
        mapper.updateEntityFromRequest(entity,request);
        AccountEntity saved = accountRepository.save(entity);
        return mapper.toResponse(saved);
    }

    public List<AccountResponse> getAccounts(){
        List<AccountEntity> entityList = accountRepository.findAll();
        return entityList.stream().map(mapper::toResponse).toList();
    }

    public AccountResponse getAccountById(Long id){
        AccountEntity entity = accountRepository.findAccountEntitiesById(id);
        return mapper.toResponse(entity);
    }
    public void deleteAccount(Long id){
        AccountEntity entity = accountRepository.findAccountEntitiesById(id);
        entity.setStatus(Status.INACTIVE);
        accountRepository.save(entity);
    }
}
