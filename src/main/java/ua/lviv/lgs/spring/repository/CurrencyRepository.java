package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.Currency;

public interface CurrencyRepository extends JpaRepository<Currency, Long> {
}
