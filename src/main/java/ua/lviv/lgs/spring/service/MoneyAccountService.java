package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.MoneyAccount;

public interface MoneyAccountService {

    MoneyAccount createMoneyAccount(MoneyAccount moneyAccount);

    MoneyAccount createDefaultMoneyAccount();

}
