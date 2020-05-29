package ua.lviv.lgs.spring.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "currency")
public class Currency {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String code;

}
