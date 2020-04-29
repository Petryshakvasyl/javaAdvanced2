package ua.lviv.lgs.pv.service;

import ua.lviv.lgs.pv.entity.User;

import java.util.Optional;

public interface UserService extends CrudService<User, Integer> {

    Optional<User> findByEmail(String email);

}
