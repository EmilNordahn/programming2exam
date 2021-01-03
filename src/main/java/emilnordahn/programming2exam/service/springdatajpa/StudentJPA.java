package emilnordahn.programming2exam.service.springdatajpa;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.repository.StudentRepository;
import emilnordahn.programming2exam.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StudentJPA implements StudentService {
    private StudentRepository sr;

    public StudentJPA(StudentRepository sr){
        this.sr = sr;
    }

    @Override
    public ArrayList<Student> findAll() {
        ArrayList<Student> students = new ArrayList<>();
        sr.findAll().forEach(students::add);
        return students;
    }

    @Override
    public Student save(Student object) {
        return sr.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        sr.deleteById(aLong);
    }

    @Override
    public Optional<Student> findById(Long aLong) {
        return sr.findById(aLong);
    }

    @Override
    public List<Student> findAllByOrderByLastNameAscFirstNameAsc() {
        return sr.findAllByOrderByLastNameAscFirstNameAsc();
    }

    @Override
    public List<Student> findAllBySupervisorOrderByLastNameAscFirstNameAsc(Supervisor supervisor) {
        return sr.findAllBySupervisorOrderByLastNameAscFirstNameAsc(supervisor);
    }
}
