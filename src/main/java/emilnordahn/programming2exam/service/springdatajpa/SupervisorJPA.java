package emilnordahn.programming2exam.service.springdatajpa;

import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.repository.SupervisorRepository;
import emilnordahn.programming2exam.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SupervisorJPA implements SupervisorService {
    private SupervisorRepository sr;

    public SupervisorJPA(SupervisorRepository sr){
        this.sr = sr;
    }
    @Override
    public ArrayList<Supervisor> findAll() {
        ArrayList<Supervisor> supervisors = new ArrayList<>();
        sr.findAll().forEach(supervisors::add);
        return supervisors;
    }

    @Override
    public Supervisor save(Supervisor object) {
        return sr.save(object);
    }

    @Override
    public void deleteById(Long aLong) {
        sr.deleteById(aLong);
    }

    @Override
    public Optional<Supervisor> findById(Long aLong) {
        return sr.findById(aLong);
    }

    @Override
    public List<Supervisor> findAllByOrderByLastNameAscFirstNameAsc() {
        return sr.findAllByOrderByLastNameAscFirstNameAsc();
    }
}
