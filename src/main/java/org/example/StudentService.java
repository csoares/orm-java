package org.example;

import org.example.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class StudentService {
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");

    public void createStudent(String name, String email) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = new Student();
        student.setName(name);
        student.setEmail(email);
        em.persist(student);
        em.getTransaction().commit();
        em.close();
    }

    public Student findStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        Student student = em.find(Student.class, id);
        em.close();
        return student;
    }

    public void updateStudent(Long id, String name, String email) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            student.setName(name);
            student.setEmail(email);
            em.merge(student);
        }
        em.getTransaction().commit();
        em.close();
    }

    public void deleteStudent(Long id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        em.getTransaction().commit();
        em.close();
    }
}
