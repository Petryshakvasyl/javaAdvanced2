package ua.lviv.lgs.pv.manytomany.entity;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @OneToOne
    private StudentCard card;
}
