package ua.lviv.lgs.pv.manytoone;

import ua.lviv.lgs.pv.manytoone.entity.Item;
import ua.lviv.lgs.pv.manytoone.entity.Order;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        Order order = new Order();
        order.setDescription("New order");

        Item item = new Item();
        item.setName("Phone");
        item.setOrder(order);

        em.persist(order);
        em.persist(item);

        em.getTransaction().commit();
    }

}
