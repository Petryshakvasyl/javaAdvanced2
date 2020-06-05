package ua.lviv.lgs.spring.domain;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements GrantedAuthority {

    @Id
    private String name;

    @Override
    public String getAuthority() {
        return name;
    }
}
