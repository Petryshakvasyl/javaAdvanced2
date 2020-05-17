package ua.lviv.lgs.pv;

import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.UserRepository;
import ua.lviv.lgs.pv.repository.impl.UserRepositoryImpl;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hibernateUnit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        UserRepository userRepository = new UserRepositoryImpl(entityManager);

//        User user = new User();
//        user.setEmail("testuser4@mail.com");
//        user.setFirstName("Test4 FirstName");
//        user.setLastName("Test4 last name");
//        userRepository.save(user);

//        System.out.println(user);

        // find user by id
        Optional<User> optionalUser = userRepository.findById(1);
        optionalUser.ifPresent(System.out::println);

        //find all users
        System.out.println("DEBUG SELECT ALL");
        List<User> users = userRepository.findAll();
        users.forEach(System.out::println);

        Optional<User> eserByEmail = userRepository.findByEmail("testuser3@mail.com");
        eserByEmail.ifPresent(System.out::println);

    }
}
