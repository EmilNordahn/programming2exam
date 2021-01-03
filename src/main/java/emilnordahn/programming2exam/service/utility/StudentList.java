package emilnordahn.programming2exam.service.utility;

import emilnordahn.programming2exam.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentList {
    public List<Student> students = new ArrayList<>();

    public StudentList() {
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "StudentList{" +
                "students=" + students +
                '}';
    }
}
