package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.Currency;

public interface CurrencyService {

    Currency create(Currency currency);

    Currency createDefault();
}
