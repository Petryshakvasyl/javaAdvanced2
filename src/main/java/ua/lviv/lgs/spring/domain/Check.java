package ua.lviv.lgs.spring.domain;

import lombok.Data;

import javax.persistence.*;

@Data

@Entity
@Table(name = "check_tb")
public class Check {

    @Id
    @GeneratedValue
    private Long id;

    @Lob
    private byte[] data;

}
