package ua.lviv.lgs.spring.service;

import ua.lviv.lgs.spring.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findUssers();

    User createUser(User user);

    Optional<User> findByEmail(String email);

    User findById(Long id);
}
