package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDTO> findAll();

    UserDTO createUser(UserDTO user);

    Optional<UserDTO> findByEmail(String email);

    Optional<UserDTO> findById(Long id);

    MoneyAccount findCurrentMoneyAccount(Long id);

    List<MoneyAccount> findUserAccounts(Long id);

    Optional<UserDTO> findByUsername(String username);

}
