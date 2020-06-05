package ua.lviv.lgs.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.domain.Type;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByMoneyAccountAndType(MoneyAccount moneyAccount, Type type, Pageable pageable);

}
