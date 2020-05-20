package ua.lviv.lgs.pv.onetomany;

import ua.lviv.lgs.pv.onetomany.entity.Address;
import ua.lviv.lgs.pv.onetomany.entity.AddressType;
import ua.lviv.lgs.pv.onetomany.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        User user = new User();
        user.setFirstName("Ivan");
        user.setLastName("Koziv");

//        Address address = em.find(Address.class, 7L);

        Address address = new Address();
        address.setAddress("Lviv, Shewchenka 22");
        address.setAddressType(AddressType.MAIL);
        address.setUser(user);

        user.getAddresses().add(address);
        em.persist(address);

        em.persist(user);

        em.getTransaction().commit();
    }

}
