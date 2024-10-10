package az.edu.orient.msaccount.account.repository;

import az.edu.orient.msaccount.account.entity.AccountEntity;
import az.edu.orient.msaccount.account.model.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {
    AccountEntity findAccountEntitiesById(Long id);
    List<AccountEntity> findAll();
    Optional<AccountEntity> findByCurrency(Currency currency);
}
