package sabanciuniv.service;

import jakarta.persistence.EntityManager;
import sabanciuniv.model.Instructor;
import sabanciuniv.repository.CrudRepository;
import sabanciuniv.utility.EntityManagerUtils;

import java.util.List;

public class InstructorService implements CrudRepository<Instructor> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Instructor> findAll() {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.createQuery("SELECT i FROM Instructor i", Instructor.class).getResultList();
    }

    @Override
    public Instructor find(long id) {
        if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
        return entityManager.find(Instructor.class, id);
    }

    @Override
    public void save(Instructor instructor) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.persist(instructor);
            entityManager.getTransaction().commit();
            System.out.println("Instructor is saved! id = " + instructor.getId());
        } catch (Exception e) {
            System.out.println("Instructor could not saved! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void delete(Instructor instructor) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            entityManager.getTransaction().begin();
            entityManager.remove(instructor);
            entityManager.getTransaction().commit();
            System.out.println("Instructor is deleted! id = " + instructor.getId());
        } catch (Exception e) {
            System.out.println("Instructor could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
    @Override
    public void delete(long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            Instructor foundInstructor = find(id);
            entityManager.getTransaction().begin();
            entityManager.remove(foundInstructor);
            entityManager.getTransaction().commit();
            System.out.println("Instructor is deleted! id = " + id);
        } catch (Exception e) {
            System.out.println("Instructor could not deleted! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

    @Override
    public void update(Instructor instructor, long id) {
        try {
            if(!entityManager.isOpen())  entityManager = EntityManagerUtils.getEntityManager("mysqlPU");
            Instructor foundInstructor = find(id);
            foundInstructor = instructor;
            entityManager.merge(foundInstructor);
            System.out.println("Instructor is updated! id = " + id);
        } catch (Exception e) {
            System.out.println("Instructor could not updated! Error = " + e );
            entityManager.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }
}
