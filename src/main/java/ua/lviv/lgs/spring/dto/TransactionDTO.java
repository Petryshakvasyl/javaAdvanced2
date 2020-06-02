package ua.lviv.lgs.spring.dto;

import lombok.Data;
import ua.lviv.lgs.spring.domain.Type;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class TransactionDTO {

    private Long id;

    private BigDecimal amount;

    private Date date;

    private String description;

    private Type type;

    private Long categoryId;
}
