package ua.lviv.lgs.pv.manytoone.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Data

@Entity
@Table(name = "tb_order")
public class Order {

    @Id
    @GeneratedValue
    private Long id;

    private String description;
}
