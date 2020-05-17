package ua.lviv.lgs.pv.entity;


import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(unique = true, nullable = false, name = "user_email")
    private String email;
}
