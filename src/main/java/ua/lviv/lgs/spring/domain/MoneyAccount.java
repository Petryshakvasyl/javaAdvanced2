package ua.lviv.lgs.spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "money_account")
public class MoneyAccount {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private BigDecimal initialBalance;

    private Instant initialDate;

    @OneToOne
    private Currency currency;

}
