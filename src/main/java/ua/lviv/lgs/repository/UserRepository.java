package ua.lviv.lgs.repository;

import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.lviv.lgs.entity.User;

@RequiredArgsConstructor
public class UserRepository {

    private final SessionFactory sessionFactory;

    public void persist(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(user);

//            session.evict(user);
//            session.persist(user);
            transaction.commit();
        }
    }

    public User save(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Long id = (Long) session.save(user);
            session.evict(user);
            Long id2 = (Long) session.save(user);
            transaction.commit();
            return user;
        }
    }

    public User merge(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            User mergedUser = (User) session.merge(user);
            transaction.commit();
            return mergedUser;
        }
    }

    public User update(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
            return user;
        }
    }

    public User saveOrUpdate(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.saveOrUpdate(user);
            transaction.commit();
            return user;
        }
    }

}
