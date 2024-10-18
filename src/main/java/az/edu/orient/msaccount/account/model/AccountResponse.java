package az.edu.orient.msaccount.account.model;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class AccountResponse {
    private Long id;
    private String name;
    private Currency currency;
    private BigDecimal balance;
    private String iban;
    private Status status;
}
