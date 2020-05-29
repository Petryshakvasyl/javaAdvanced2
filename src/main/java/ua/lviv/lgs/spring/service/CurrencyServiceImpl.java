package ua.lviv.lgs.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.Currency;
import ua.lviv.lgs.spring.repository.CurrencyRepository;

@Slf4j
@Service
public class CurrencyServiceImpl implements CurrencyService {

    private final CurrencyRepository currencyRepository;

    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public Currency create(Currency currency) {
        return currencyRepository.save(currency);
    }

    @Override
    public Currency createDefault() {
        log.debug("create default currency for the user");
        Currency currency = new Currency();
        currency.setName("Hryvna");
        currency.setCode("UAH");
        return currencyRepository.save(currency);
    }
}
