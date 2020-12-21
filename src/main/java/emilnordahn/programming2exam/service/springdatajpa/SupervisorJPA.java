package emilnordahn.programming2exam.service.springdatajpa;

import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.repository.SupervisorRepository;
import emilnordahn.programming2exam.service.SupervisorService;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SupervisorJPA implements SupervisorService {
    private SupervisorRepository sr;

    public SupervisorJPA(SupervisorRepository sr){
        this.sr = sr;
    }
    @Override
    public Set<Supervisor> findAll() {
        Set<Supervisor> set = new HashSet<>();
        sr.findAll().forEach(set::add);
        return set;
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
