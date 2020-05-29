package ua.lviv.lgs.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Type type;
}
