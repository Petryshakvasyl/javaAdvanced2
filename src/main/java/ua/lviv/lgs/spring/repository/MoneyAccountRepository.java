package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.MoneyAccount;

public interface MoneyAccountRepository extends JpaRepository<MoneyAccount, Long> {
}
