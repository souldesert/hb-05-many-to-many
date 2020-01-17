package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import ru.voskhod.hibernate.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class GetCoursesForMaryDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // get student Mary from the database
            int id = 2;
            Student mary = entityManager.find(Student.class, id);

            System.out.println("Found student: " + mary);
            System.out.println("Student's courses: " + mary.getCourses());

            // commit transaction
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
