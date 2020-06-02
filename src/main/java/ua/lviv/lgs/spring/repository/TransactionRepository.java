package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}
