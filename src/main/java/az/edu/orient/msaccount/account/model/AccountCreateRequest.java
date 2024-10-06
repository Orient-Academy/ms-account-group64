package az.edu.orient.msaccount.account.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreateRequest {
    private String name;
    private Currency currency;
    private BigDecimal balance;
}
