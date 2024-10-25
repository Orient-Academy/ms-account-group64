package az.edu.orient.msaccount.account.entity;

import az.edu.orient.msaccount.account.model.Currency;
import az.edu.orient.msaccount.account.model.Status;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    private String iban;
    private BigDecimal balance;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "user_id")
    private Long userId;
}
