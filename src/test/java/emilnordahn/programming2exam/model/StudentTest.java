package emilnordahn.programming2exam.model;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {

    @Order(1)
    @Test
    void canCreateObject(){
        assertNotNull(new Student());
    }

    @Order(2)
    @Test
    void canUpdateAndReadObject(){
        Student student = new Student();
        student.setFirstName("Hans");
        assertEquals("Hans", student.getFirstName());
    }

}