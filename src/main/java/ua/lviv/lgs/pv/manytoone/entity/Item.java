package ua.lviv.lgs.pv.manytoone.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "fk_order_id")
    private Order order;
}
