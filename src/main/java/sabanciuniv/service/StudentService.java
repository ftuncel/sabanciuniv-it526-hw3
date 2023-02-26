package sabanciuniv.service;

import jakarta.persistence.EntityManager;
import sabanciuniv.model.Student;
import sabanciuniv.repository.CrudRepository;
import sabanciuniv.utility.EntityManagerUtils;

import java.util.List;

public class StudentService implements CrudRepository<Student> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Override
    public Student find(long id) {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.find(Student.class, id);
    }

    @Override
    public void save(Student student) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
            System.out.println("Student is saved! id = " + student.getId());
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(Student student) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.remove(student);
            entityManager.getTransaction().commit();
            System.out.println("Student is deleted! id = " + student.getId());
        } catch (Exception e) {
            System.out.println("Student could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            Student foundStudent = find(id);
            entityManager.getTransaction().begin();
            entityManager.remove(foundStudent);
            entityManager.getTransaction().commit();
            System.out.println("Student is deleted! id = " + id);
        } catch (Exception e) {
            System.out.println("Student could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void update(Student student, long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            Student foundStudent = find(id);
            foundStudent = student;
            entityManager.getTransaction().begin();
            entityManager.merge(foundStudent);
            entityManager.getTransaction().commit();
            System.out.println("Student is updated! id = " + id);
        } catch (Exception e) {
            System.out.println("Student could not updated! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
