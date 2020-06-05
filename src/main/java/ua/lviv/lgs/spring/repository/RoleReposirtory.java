package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.Role;

public interface RoleReposirtory extends JpaRepository<Role, String> {
    Role findByName(String name);
}
