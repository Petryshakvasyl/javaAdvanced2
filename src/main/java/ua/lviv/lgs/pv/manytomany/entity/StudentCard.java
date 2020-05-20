package ua.lviv.lgs.pv.manytomany.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data

@Entity
@Table(name = "card")
public class StudentCard {

    @Id
    @GeneratedValue
    private Long id;

    private String number;
}
