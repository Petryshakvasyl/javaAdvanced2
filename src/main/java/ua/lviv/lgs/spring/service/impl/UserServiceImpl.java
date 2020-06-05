package ua.lviv.lgs.spring.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.dto.UserDTO;
import ua.lviv.lgs.spring.error.ResourceNotFoundException;
import ua.lviv.lgs.spring.repository.RoleReposirtory;
import ua.lviv.lgs.spring.repository.UserRepository;
import ua.lviv.lgs.spring.service.MoneyAccountService;
import ua.lviv.lgs.spring.service.UserService;
import ua.lviv.lgs.spring.service.mapper.UserMapper;

import javax.transaction.Transactional;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final MoneyAccountService moneyAccountService;
    private final UserMapper userMapper;
    private final BCryptPasswordEncoder encoder;
    private final RoleReposirtory roleReposirtory;

    public UserServiceImpl(UserRepository userRepository, MoneyAccountService moneyAccountService, UserMapper userMapper, BCryptPasswordEncoder encoder, RoleReposirtory roleReposirtory) {
        this.userRepository = userRepository;
        this.moneyAccountService = moneyAccountService;
        this.userMapper = userMapper;
        this.encoder = encoder;
        this.roleReposirtory = roleReposirtory;
    }

    @Override
    public List<UserDTO> findAll() {
        return Collections.emptyList();
    }

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        User user = userMapper.toEntity(userDTO);
        user.getRoles().add(roleReposirtory.findByName("ROLE_USER"));
        user.setPassword(encoder.encode(user.getPassword()));
        MoneyAccount defaultMoneyAccount = moneyAccountService.createDefaultMoneyAccount();
        user.setCurrentAccount(defaultMoneyAccount);
        user.getAccounts().add(defaultMoneyAccount);
        return userMapper.toDto(userRepository.save(user));
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        return userRepository.findByEmail(email).map(userMapper::toDto);
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        log.debug("find user by id {}", id);
        return userRepository.findById(id).map(userMapper::toDto);
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

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        return userRepository.findByUsername(username).map(userMapper::toDto);
    }
}
