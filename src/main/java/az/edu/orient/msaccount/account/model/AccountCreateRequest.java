package az.edu.orient.msaccount.account.model;

import az.edu.orient.msaccount.account.validation.OnlyUSDCurrency;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;
    @OnlyUSDCurrency(message = "We open only USD bank account")
    private Currency currency;
    @PositiveOrZero(message = "Balance could be negative number")
    private BigDecimal balance;
    private Long userId;;

}
