package ua.lviv.lgs.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.lviv.lgs.spring.domain.MoneyAccount;
import ua.lviv.lgs.spring.domain.User;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {

    Optional<User> findByEmail(String email);

    Optional<User> findByFirstName(String firstName);

    @Query("select u from User u where u.firstName =?1 and u.lastName = ?2")
    List<User> findUser(String firstName, String lastName);

    @Query("select u.accounts from User u where u.id = ?1")
    List<MoneyAccount> findMoneyAccounts(Long id);

    @Query("select u.currentAccount from User u where u.id = ?1")
    Optional<MoneyAccount> findUsersCurrentAccount(Long id);

    Optional<User> findByUsername(String name);
}
