package ua.lviv.lgs.spring.repository;

import ua.lviv.lgs.spring.domain.User;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> findUsersByBirthdy(String birthday);
}
