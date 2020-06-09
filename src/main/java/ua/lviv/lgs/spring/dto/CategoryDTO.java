package ua.lviv.lgs.spring.dto;

import lombok.Data;
import ua.lviv.lgs.spring.domain.Type;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
public class CategoryDTO {

    private Long id;

    @Email
    private String name;

    @NotNull
    private Type type;
}
