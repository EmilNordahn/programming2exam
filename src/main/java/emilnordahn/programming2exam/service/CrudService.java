package emilnordahn.programming2exam.service;

import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

public interface CrudService<T, ID> {
    ArrayList<T> findAll();
    T save(T object);
    void deleteById(ID id);
    Optional<T> findById(ID id);
}
