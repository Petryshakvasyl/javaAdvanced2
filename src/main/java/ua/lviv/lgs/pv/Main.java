package ua.lviv.lgs.pv;

import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.UserRepository;
import ua.lviv.lgs.pv.repository.impl.UserRepositoryImpl;

import java.sql.Connection;
import java.util.List;

import static ua.lviv.lgs.pv.ConnectionManager.createConnection;

public class Main {

    public static void main(String[] args) {

        Connection connection = createConnection();

        UserRepository userRepository = new UserRepositoryImpl(connection);
        // create new user
        //        User user = new User("Ivan", "Dovrzenko");
        //        userRepository.save(user);
        //        System.out.println(user);

        List<User> allUsers = userRepository.findAll();

        System.out.println(allUsers);


    }
}
