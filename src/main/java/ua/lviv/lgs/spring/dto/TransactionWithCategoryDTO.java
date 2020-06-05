package ua.lviv.lgs.spring.dto;

import lombok.Data;
import ua.lviv.lgs.spring.domain.Type;

import java.math.BigDecimal;

@Data
public class TransactionWithCategoryDTO {

    private Long id;

    private BigDecimal amount;

    private String date;

    private String description;

    private Type type;

    private CategoryDTO category;
}
