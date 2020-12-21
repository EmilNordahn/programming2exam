package emilnordahn.programming2exam.service.utility;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;

public class AJAXrequest {
    String firstName;
    String lastName;
    String email;
    String type;

    public AJAXrequest() {
    }

    public AJAXrequest(String firstName) {
        this.firstName = firstName;
    }

    public Student toStudent(){
        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setEmail(email);
        return student;
    }

    public Supervisor toSupervisor(){
        Supervisor supervisor = new Supervisor();
        supervisor.setFirstName(firstName);
        supervisor.setLastName(lastName);
        supervisor.setEmail(email);
        return supervisor;
    }

    @Override
    public String toString() {
        return "AJAXrequest{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
