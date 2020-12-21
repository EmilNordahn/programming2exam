package emilnordahn.programming2exam.repository;

import emilnordahn.programming2exam.model.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SupervisorRepository extends CrudRepository<Supervisor, Long> {
    List<Supervisor> findAllByOrderByLastNameAscFirstNameAsc();
}
