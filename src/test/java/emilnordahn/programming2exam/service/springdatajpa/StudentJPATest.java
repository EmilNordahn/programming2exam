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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentJPATest {

    @Autowired
    StudentService studentService;

    @Order(1)
    @Test
    void crudTest(){
        String testName = "test name";
        String testMail = "test mail";
        Student student = new Student();

        student.setFirstName(testName);

        //save returnerer et student object med ID fra DB
        student = studentService.save(student);

        //Checker om den kan gemmes i DB
        assertNotNull(student.getStudentID());

        //Checker at den kan læse fra DB
        assertTrue(studentService.findAll().size() > 0);

        //Checker om den kan finde den specifikke student baseret på ID
        assertEquals(student.getStudentID(), studentService.findById(student.getStudentID()).get().getStudentID());

        //Checker om mail er opdateret i DB
        student.setEmail(testMail);
        student = studentService.save(student);
        assertEquals(student.getEmail(), studentService.findById(student.getStudentID()).get().getEmail());

        //Checker om den kan slette Studenten fra DB
        studentService.deleteById(student.getStudentID());
        assertTrue(studentService.findById(student.getStudentID()).isEmpty());
    }
}