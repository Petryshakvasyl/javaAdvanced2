package ua.lviv.lgs.spring.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.spring.domain.User;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class UserRepositoryCustomImpl implements UserRepositoryCustom {

    @Autowired
    EntityManager em;

    @Override
    public List<User> findUsersByBirthdy(String birthday) {
        return null;
    }
}
