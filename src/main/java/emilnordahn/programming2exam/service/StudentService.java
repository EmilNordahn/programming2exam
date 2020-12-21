package emilnordahn.programming2exam.service;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;

import java.util.List;
import java.util.Optional;

public interface StudentService extends CrudService<Student, Long>{
    List<Student> findAllByOrderByLastNameAscFirstNameAsc();
    List<Student> findAllBySupervisorOrderByLastNameAscFirstNameAsc(Supervisor supervisor);
}
