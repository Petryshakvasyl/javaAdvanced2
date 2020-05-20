package ua.lviv.lgs.pv.manytomany;

import ua.lviv.lgs.pv.manytomany.entity.Group;
import ua.lviv.lgs.pv.manytomany.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hibernateUnit");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();


        Group group = new Group();
        group.setName("java_19:00");

        Student student = new Student();
        student.setFirstName("Moroz");
        student.setLastName("Andry");

        Student student2 = new Student();
        student2.setFirstName("Roman");
        student2.setLastName("Taras");
        em.persist(student);
        em.persist(student2);

        group.getStudents().add(student);
        group.getStudents().add(student2);

        em.persist(group);

        Group group2 = new Group();
        group2.setName("no_name");
        group2.getStudents().add(student2);
        em.persist(group2);

        em.getTransaction().commit();


    }

}
