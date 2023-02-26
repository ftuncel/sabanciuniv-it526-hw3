package sabanciuniv.service;

import jakarta.persistence.EntityManager;
import sabanciuniv.model.Course;
import sabanciuniv.repository.CrudRepository;
import sabanciuniv.utility.EntityManagerUtils;

import java.util.List;

public class CourseService implements CrudRepository<Course> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course find(long id) {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.find(Course.class, id);
    }

    @Override
    public void save(Course course) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
            System.out.println("Course is saved! id = " + course.getId());
        } catch (Exception e) {
            System.out.println("Course could not saved! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(Course course) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.remove(course);
            entityManager.getTransaction().commit();
            System.out.println("Course is deleted! id = " + course.getId());
        } catch (Exception e) {
            System.out.println("Course could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
    @Override
    public void delete(long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            Course foundCourse = find(id);
            entityManager.remove(foundCourse);
            entityManager.getTransaction().commit();
            System.out.println("Course is deleted! id = " + id);
        } catch (Exception e) {
            System.out.println("Course could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void update(Course course, long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            Course foundCourse = find(id);
            foundCourse = course;
            entityManager.getTransaction().begin();
            entityManager.merge(foundCourse);
            entityManager.getTransaction().commit();
            System.out.println("Course is updated! id = " + id);
        } catch (Exception e) {
            System.out.println("Course could not updated! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
