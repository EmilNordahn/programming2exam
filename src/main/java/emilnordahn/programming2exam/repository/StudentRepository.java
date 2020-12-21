package emilnordahn.programming2exam.repository;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {
    List<Student> findAllByOrderByLastNameAscFirstNameAsc();
    List<Student> findAllBySupervisorOrderByLastNameAscFirstNameAsc(Supervisor supervisor);
}
