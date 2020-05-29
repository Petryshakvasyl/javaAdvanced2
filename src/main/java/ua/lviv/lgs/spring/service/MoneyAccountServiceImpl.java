package ua.lviv.lgs.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.Currency;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.repository.MoneyAccountRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.Instant;

@Service
@Slf4j
public class MoneyAccountServiceImpl implements MoneyAccountService {

    private final MoneyAccountRepository moneyAccountRepository;

    private final CurrencyService currencyService;

    public MoneyAccountServiceImpl(MoneyAccountRepository moneyAccountRepository, CurrencyService currencyService) {
        this.moneyAccountRepository = moneyAccountRepository;
        this.currencyService = currencyService;
    }

    @Override
    public MoneyAccount createMoneyAccount(MoneyAccount moneyAccount) {
        return moneyAccountRepository.save(moneyAccount);
    }

    @Override
    @Transactional
    public MoneyAccount createDefaultMoneyAccount() {
        Currency currency = currencyService.createDefault();
        MoneyAccount moneyAccount = new MoneyAccount();
        moneyAccount.setInitialBalance(new BigDecimal(0));
        moneyAccount.setInitialDate(Instant.now());
        moneyAccount.setCurrency(currency);
        return moneyAccountRepository.save(moneyAccount);
    }

    private Currency createDefaultCurrency() {
        //todo implement method
        return null;
    }
}
