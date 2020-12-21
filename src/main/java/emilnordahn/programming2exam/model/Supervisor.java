package emilnordahn.programming2exam.model;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "supervisors")
public class Supervisor {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name = "supervisor_id")
    private Long supervisorId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String email;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "supervisor_id")
    private Set<Student> students;

    public Supervisor(Long supervisorId, String firstName, String lastName, String email, Set<Student> students) {
        this.supervisorId = supervisorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.students = students;
    }

    public Supervisor() {
    }

    public void addStudent(Student student) {
        student.setSupervisor(this);
        if (this.students == null) {
            setStudents(new HashSet<>());
        }
        students.add(student);
    }

    public Student removeStudent(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
        student.setSupervisor(null);
        return student;
    }

    public List<Student> listStudents(){
        ArrayList<Student> list = new ArrayList<>();
        if (students.isEmpty()){
            return list;
        }
        Iterator<Student> it = students.iterator();
        while (it.hasNext()){
            list.add(it.next());
        }
        return list;
    }

    @Override
    public String toString() {
        return "Supervisor{" +
                "supervisorId=" + supervisorId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", students=" + students +
                '}';
    }

    public Long getSupervisorId() {
        return supervisorId;
    }

    public void setSupervisorId(Long supervisorId) {
        this.supervisorId = supervisorId;
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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
