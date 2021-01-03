package emilnordahn.programming2exam.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import javax.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "student_id")
    private Long studentId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @ManyToOne @JoinColumn(name = "supervisor_id") @Nullable @JsonIgnore
    private Supervisor supervisor;

    private Long sId;

    public Student() {
    }

    public Student(Long studentId, String firstName, String lastName, String email, Supervisor supervisor) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.supervisor = supervisor;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", supervisor=" + supervisor +
                ", sId=" + sId +
                '}';
    }

    public Long getsId() {
        return sId;
    }

    public void setsId(Long sId) {
        this.sId = sId;
    }

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentID) {
        this.studentId = studentID;
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

    public Supervisor getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Supervisor supervisor) {
        this.supervisor = supervisor;
    }
}
