package bg.tu_varna.sit.library.data.repositories;

import java.util.List;
import java.util.Optional;

public interface DAORepository<T> {
    void save (T obk);
    void update(T obj);
    void delete (T obj);
    Optional<T> getByIg(Long id);
    List<T> getAll();
}