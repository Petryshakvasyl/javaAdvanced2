package ua.lviv.lgs.spring.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.lviv.lgs.spring.domain.*;
import ua.lviv.lgs.spring.dto.TransactionDTO;
import ua.lviv.lgs.spring.repository.*;
import ua.lviv.lgs.spring.service.mapper.TransactionMapper;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@SpringBootTest
class TransactionServiceImplTest {

    @Autowired
    private CurrencyRepository currencyRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MoneyAccountRepository moneyAccountRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private TransactionMapper transactionMapper;

    private TransactionServiceImpl transactionService;

    @BeforeEach
    void setUp() {
        transactionService = new TransactionServiceImpl(transactionRepository, userRepository, transactionMapper);
    }

    @Test
    @Transactional
    void createInCurrentUserAccount() {

        Currency currency = new Currency();
        currency.setCode("UAH");
        currency.setCode("Hryvnia");
        currencyRepository.save(currency);

        MoneyAccount moneyAccount = new MoneyAccount();
        moneyAccount.setCurrency(currency);
        moneyAccount.setInitialDate(Instant.now());
        moneyAccount.setInitialBalance(new BigDecimal(0));
        moneyAccountRepository.save(moneyAccount);

        User user = new User();
        user.setFirstName("test");
        user.setLastName("test1");
        user.setCurrentAccount(moneyAccount);
        user.getAccounts().add(moneyAccount);
        user.setEmail("email");
        user.setUsername("username");

        userRepository.save(user);

        Category category = new Category();
        category.setName("Transport");
        category.setType(Type.EXPENSE);

        categoryRepository.save(category);

        TransactionDTO transactionDTO = new TransactionDTO();
        transactionDTO.setType(Type.EXPENSE);
        transactionDTO.setAmount(new BigDecimal(100));
        transactionDTO.setDate(new Date());
        transactionDTO.setCategoryId(category.getId());

        TransactionDTO savedTransaction = transactionService.createInCurrentUserAccount(transactionDTO, user.getId());


    }
}
