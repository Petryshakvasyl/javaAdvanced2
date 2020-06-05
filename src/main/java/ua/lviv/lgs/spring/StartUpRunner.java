package ua.lviv.lgs.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.lviv.lgs.spring.domain.Category;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.Transaction;
import ua.lviv.lgs.spring.repository.MoneyAccountRepository;
import ua.lviv.lgs.spring.repository.TransactionRepository;
import ua.lviv.lgs.spring.service.CategoryService;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
@RequiredArgsConstructor
public class StartUpRunner implements CommandLineRunner {

    private final CategoryService categoryService;

    private final MoneyAccountRepository moneyAccountRepository;

    private final TransactionRepository transactionRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {

        List<Category> categoryList = categoryService.findAll();
        MoneyAccount moneyAccount = moneyAccountRepository.findById(2L).get();

        List<Transaction> transactions = IntStream.range(0, 150).mapToObj(i -> {
            Category category = categoryList.get(ThreadLocalRandom.current().nextInt(categoryList.size()));
            Transaction transaction = new Transaction();
            transaction.setCategory(category);
            transaction.setType(category.getType());
            transaction.setAmount(BigDecimal.valueOf(ThreadLocalRandom.current().nextDouble(500)));
            transaction.setDate(Instant.now().minus(ThreadLocalRandom.current().nextInt(30), ChronoUnit.DAYS));
            transaction.setMoneyAccount(moneyAccount);
            return transaction;
        }).collect(Collectors.toList());
        transactionRepository.saveAll(transactions);

    }

}
