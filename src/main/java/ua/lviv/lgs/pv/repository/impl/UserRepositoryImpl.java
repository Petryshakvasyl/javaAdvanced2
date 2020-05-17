package ua.lviv.lgs.pv.repository.impl;

import lombok.RequiredArgsConstructor;
import ua.lviv.lgs.pv.entity.User;
import ua.lviv.lgs.pv.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

@NamedQueries(
        @NamedQuery(name = "findByEmail", query = "select u from User u where u.email = ?1")
)
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Override
    public void save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
    }

    public Optional<User> findByEmail(String email) {
        TypedQuery<User> query = entityManager.createNamedQuery("findByEmail", User.class);
        query.setParameter(1, email);
        User user = query.getSingleResult();
        return Optional.ofNullable(user);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public Optional<User> findById(Integer id) {
        User user = entityManager.find(User.class, id);
        return Optional.ofNullable(user);
    }

    @Override
    public List<User> findAll() {
        //JPQL
        // select * from user
//        Query query = entityManager.createQuery("select u from User u");
//        List<User> users = query.getResultList();

        TypedQuery<User> query = entityManager.createQuery("select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public void deleteById(Integer id) {

    }
}
