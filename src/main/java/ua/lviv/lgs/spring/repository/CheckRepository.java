package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.Check;

public interface CheckRepository extends JpaRepository<Check, Long> {
}
