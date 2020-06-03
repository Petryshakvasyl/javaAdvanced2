package ua.lviv.lgs.spring.dto;

import lombok.Data;
import ua.lviv.lgs.spring.controller.validators.DateConstrain;
import ua.lviv.lgs.spring.domain.Type;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class TransactionDTO {

    private Long id;

    @NotNull(message = "Amount is required")
    @Min(value = 1, message = "you need provide min amount")
    private BigDecimal amount;

    @NotNull(message = "please choose date")
    @DateConstrain
    private String date;

    private String description;

    @NotNull
    private Type type;

    @NotNull(message = "please select a category")
    private Long categoryId;
}
