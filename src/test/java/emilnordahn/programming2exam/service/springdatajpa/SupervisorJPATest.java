package emilnordahn.programming2exam.service.springdatajpa;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.service.StudentService;
import emilnordahn.programming2exam.service.SupervisorService;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupervisorJPATest {
    @Autowired
    SupervisorService supervisorService;
    @Autowired
    StudentService studentService;

    @Order(1)
    @Test
    void crudTest(){
        String testName = "test name";
        String testMail = "test mail";
        Supervisor supervisor = new Supervisor();

        supervisor.setFirstName(testName);

        //save returnerer et Supervisor object med ID fra DB
        supervisor = supervisorService.save(supervisor);

        //Checker om den kan gemmes i DB
        assertNotNull(supervisor.getSupervisorId());

        //Checker at den kan læse fra DB
        assertTrue(supervisorService.findAll().size() > 0);

        //Checker om den kan finde den specifikke supervisor baseret på ID
        assertEquals(supervisor.getSupervisorId(), supervisorService.findById(supervisor.getSupervisorId()).get().getSupervisorId());

        //Checker om mail er opdateret i DB
        supervisor.setEmail(testMail);
        supervisor = supervisorService.save(supervisor);
        assertEquals(supervisor.getEmail(), supervisorService.findById(supervisor.getSupervisorId()).get().getEmail());

        //Checker om den kan slette Supervisoren fra DB
        supervisorService.deleteById(supervisor.getSupervisorId());
        assertTrue(supervisorService.findById(supervisor.getSupervisorId()).isEmpty());
    }

    @Test
    @Order(2)
    void relationTest(){
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Supervisor supervisor = supervisorService.save(new Supervisor());

        supervisor.addStudent(student1);
        supervisor.addStudent(student2);
        supervisor.addStudent(student3);

        supervisor = supervisorService.save(supervisor);

        assertEquals(3, supervisor.listStudents().size());
        assertEquals(3, supervisorService.findById(supervisor.getSupervisorId()).get().listStudents().size());

        //Ikke del af test, rydder bare op i DB efter, funktionalitet bliver testet i andre tests
        for (Student student : supervisor.listStudents()) {
            studentService.deleteById(student.getStudentID());
        }
        supervisorService.deleteById(supervisor.getSupervisorId());
    }
}