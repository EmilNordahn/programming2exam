package emilnordahn.programming2exam.model;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SupervisorTest {

    @Order(1)
    @Test
    void canCreateObject(){
        assertNotNull(new Supervisor());
    }

    @Order(2)
    @Test
    void canUpdateAndReadObject(){
        Supervisor supervisor = new Supervisor();
        supervisor.setFirstName("Hans");
        assertEquals("Hans", supervisor.getFirstName());
    }

}