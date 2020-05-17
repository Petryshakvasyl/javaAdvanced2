package ua.lviv.lgs.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class Book {

    private Integer id;
    private String name;
    private String description;
    private String isbn;
}
