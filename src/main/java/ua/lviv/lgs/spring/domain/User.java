package ua.lviv.lgs.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @OneToOne
    private MoneyAccount currentAccount;

    @OneToMany
    @JoinColumn(name = "user_id")
    private Set<MoneyAccount> accounts = new HashSet<>();

}
