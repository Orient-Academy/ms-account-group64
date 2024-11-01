package az.edu.orient.msaccount.account.mapper;

import az.edu.orient.msaccount.account.entity.AccountEntity;
import az.edu.orient.msaccount.account.model.AccountCreateRequest;
import az.edu.orient.msaccount.account.model.AccountResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AccountMapper {
   // AccountMapper INSTANCE = Mappers.getMapper(AccountMapper.class);
    @Mapping(target = "iban",ignore = true)
    @Mapping(target = "status",ignore = true)
    AccountEntity toEntity(AccountCreateRequest request);

 AccountResponse toResponse(AccountEntity entity);

    //List<AccountResponse> toResponse(List<AccountEntity> entity

    void updateEntityFromRequest(@MappingTarget AccountEntity entity, AccountCreateRequest request);
}
