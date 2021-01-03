package emilnordahn.programming2exam.service.utility;

import emilnordahn.programming2exam.model.Supervisor;

import java.util.ArrayList;
import java.util.List;

public class SupervisorList {
    public List<Supervisor> supervisors = new ArrayList<>();

    public SupervisorList() {
    }

    public void setSupervisors(List<Supervisor> supervisors) {
        this.supervisors = supervisors;
    }
}
