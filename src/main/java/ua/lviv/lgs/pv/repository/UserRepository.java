package ua.lviv.lgs.pv.repository;

import ua.lviv.lgs.pv.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void save(User user);

    void update(User user);

    Optional<User> findById(Integer id);

    List<User> findAll();

    Optional<User> findByEmail(String email);

    void deleteById(Integer id);

    //crud create read update delete
}
