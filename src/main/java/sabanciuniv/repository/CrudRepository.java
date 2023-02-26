package sabanciuniv.repository;

import java.util.List;

public interface CrudRepository<T> {
    List<T> findAll();
    T find(long id);
    void save(T object);
    void delete(T object);
    void delete(long id);
    void update(T object, long id);
}
