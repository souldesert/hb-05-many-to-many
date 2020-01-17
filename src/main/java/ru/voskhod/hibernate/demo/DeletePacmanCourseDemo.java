package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeletePacmanCourseDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // get the pacman course
            int courseId = 10;
            Course pacmanCourse = entityManager.find(Course.class, courseId);

            // delete the course
            System.out.println("Deleting course: " + pacmanCourse);
            entityManager.remove(pacmanCourse);

            // commit transaction
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
