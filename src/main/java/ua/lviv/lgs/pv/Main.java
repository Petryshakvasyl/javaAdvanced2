package ua.lviv.lgs.pv;

import ua.lviv.lgs.pv.config.ConnectionManager;
import ua.lviv.lgs.pv.repository.UserRepository;
import ua.lviv.lgs.pv.repository.impl.UserRepositoryImpl;

import java.sql.Connection;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start project");

        Connection connection = ConnectionManager.createConnection();
        UserRepository userRepository = UserRepositoryImpl.getInstance();

        //        User user = new User();
        //        user.setFirstName("Ivan");
        //        user.setLastName("Dovzenko");
        //        user.setEmail("ivan@dovzenko.com");
        //        user.setPassword("assgjfkjasjfd123");
        //        user.setRole("USER");
        //        userRepository.save(user);
        //
        //        List<User> users = userRepository.findAll();
        //        System.out.println(users);

        //  find b id;

        //        Optional<User> optionalUser = userRepository.findById(2);
        //
        //        optionalUser.ifPresent(System.out::println);

        //delete by id
        userRepository.deleteById(2);

    }
}
