package ru.voskhod.hibernate.demo;

import ru.voskhod.hibernate.demo.entity.Course;
import ru.voskhod.hibernate.demo.entity.Review;
import ru.voskhod.hibernate.demo.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CreateCourseAndStudentsDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence Unit");
        EntityManager entityManager = emf.createEntityManager();

        try {
            entityManager.getTransaction().begin();

            // create a course
            Course course = new Course("Pacman: How To Score One Million Points");

            // save the course

            entityManager.persist(course);
            System.out.println("Course saved: " + course);

            // create the students
            Student studentOne = new Student("John", "Doe", "john@luv2code.com");
            Student studentTwo = new Student("Mary", "Public", "mary@luv2code.com");

            // add the students to the course
            course.addStudent(studentOne);
            course.addStudent(studentTwo);

            // save the students
            System.out.println("\nSaving students");
            entityManager.persist(studentOne);
            entityManager.persist(studentTwo);
            System.out.println("Saved students: " + course.getStudents());

            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
            emf.close();
        }
    }
}
