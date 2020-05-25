package ua.lviv.lgs.spring.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ua.lviv.lgs.spring.domain.User;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class UserRepositoryTest {

    public static final String FIRST_NAME = "test name";
    public static final String LAST_NAME = "test last";

    @Autowired
    private UserRepository userRepository;

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
        createUser();
    }

    private User createUser() {
        User user = new User();
        user.setEmail("test@mail.com");
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setPhone("12345678");
        return userRepository.save(user);
    }

    @Test
    void findByFirstNameTest() {

        Optional<User> optionalUser = userRepository.findByFirstName(FIRST_NAME);
        assertTrue(optionalUser.isPresent());
        assertEquals(FIRST_NAME, optionalUser.get().getFirstName());
    }

    @Test
    void findByFirstNameAndLastNameTest() {

        List<User> users = userRepository.findUser(FIRST_NAME, LAST_NAME);
        assertThat(users).hasSize(1);
        User actualUser = users.get(0);
        assertEquals(FIRST_NAME, actualUser.getFirstName());
        assertEquals(LAST_NAME, actualUser.getLastName());
    }

    @Test
    void findByFirstNameAndLastNameTest2() {
        createUser();
        List<User> users = userRepository.findUser(FIRST_NAME, LAST_NAME);
        assertThat(users).hasSize(2);
    }
}
