package ua.lviv.lgs.spring.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.repository.UserRepository;
import ua.lviv.lgs.spring.service.error.ResourceNotFoundException;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final MoneyAccountService moneyAccountService;

    public UserServiceImpl(UserRepository userRepository, MoneyAccountService moneyAccountService) {
        this.userRepository = userRepository;
        this.moneyAccountService = moneyAccountService;
    }


    @Override
    public List<User> findAll() {
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public User createUser(User user) {
        MoneyAccount defaultMoneyAccount = moneyAccountService.createDefaultMoneyAccount();
        user.setCurrentAccount(defaultMoneyAccount);
        user.getAccounts().add(defaultMoneyAccount);
        return userRepository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findById(Long id) {
        log.debug("find user by id {}", id);
        return userRepository.findById(id);
    }

    @Override
    public MoneyAccount findCurrentMoneyAccount(Long userId) {
//        User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
//        return user.getCurrentAccount();

        return userRepository.findUsersCurrentAccount(userId).orElseThrow(() -> new ResourceNotFoundException(userId));
    }

    @Override
    public List<MoneyAccount> findUserAccounts(Long userId) {
        return userRepository.findMoneyAccounts(userId);
    }
}
