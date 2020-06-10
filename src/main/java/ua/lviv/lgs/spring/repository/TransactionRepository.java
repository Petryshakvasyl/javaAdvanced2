package ua.lviv.lgs.spring.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.lviv.lgs.spring.domain.Check;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.domain.Type;

import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Page<Transaction> findByMoneyAccountAndType(MoneyAccount moneyAccount, Type type, Pageable pageable);

    @Query("select t.check from Transaction t where t.id = ?1")
    Optional<Check> findTransactionCheck(Long transactionId);

}
