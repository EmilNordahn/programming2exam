package emilnordahn.programming2exam.service;

import emilnordahn.programming2exam.model.Supervisor;

import java.util.List;

public interface SupervisorService extends CrudService<Supervisor, Long> {
    List<Supervisor> findAllByOrderByLastNameAscFirstNameAsc();
}
