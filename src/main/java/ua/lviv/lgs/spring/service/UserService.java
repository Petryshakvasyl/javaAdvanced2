package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    User createUser(User user);

    Optional<User> findByEmail(String email);

    Optional<User> findById(Long id);

    MoneyAccount findCurrentMoneyAccount(Long id);

    List<MoneyAccount> findUserAccounts(Long id);

}
