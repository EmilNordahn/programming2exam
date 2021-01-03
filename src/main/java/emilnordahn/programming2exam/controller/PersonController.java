package emilnordahn.programming2exam.controller;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.service.StudentService;
import emilnordahn.programming2exam.service.SupervisorService;
import emilnordahn.programming2exam.service.utility.AJAXrequest;
import emilnordahn.programming2exam.service.utility.Result;
import emilnordahn.programming2exam.service.utility.StudentList;
import emilnordahn.programming2exam.service.utility.SupervisorList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class PersonController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private SupervisorService supervisorService;

    public PersonController(StudentService studentService, SupervisorService supervisorService){
        this.studentService = studentService;
        this.supervisorService = supervisorService;
    }

    @PostMapping("api/getStudents")
    public ResponseEntity<StudentList> getSearchStudentsResult(){
        System.out.println("api/getStudents called");
        StudentList studentList = new StudentList();
        studentList.setStudents(studentService.findAll());

        System.out.println("before forloop");
        for (Student s : studentList.students) {
            System.out.println("in the loop now\nsId = "+s.getsId());
            if (s.getSupervisor() != null) {
                System.out.println("sId: " + s.getSupervisor().getSupervisorId());
                s.setsId(s.getSupervisor().getSupervisorId());
            }
        }

        System.out.println(studentList.toString());

        return ResponseEntity.ok(studentList);
    }

    @PostMapping("api/getSupervisors")
    public ResponseEntity<SupervisorList> getSupervisorResult(){
        System.out.println("api/getsupervisors called");
        SupervisorList supervisorList = new SupervisorList();
        supervisorList.setSupervisors(supervisorService.findAll());

        return ResponseEntity.ok(supervisorList);
    }

    @PostMapping("api/deletePerson")
    public void deletePerson(@RequestBody AJAXrequest request){
        if (request.getType().equals("student")){
            studentService.deleteById(request.getsId());
        } else if (request.getType().equals("supervisor")){
            supervisorService.deleteById(request.getsId());
        }
    }

    @PostMapping("api/addPerson")
    public ResponseEntity<AJAXrequest> getAddStudentResult(@RequestBody AJAXrequest request) {
        System.out.println("api/add was called with: " + request.toString());

//        Result  result = new Result();

        if (request.getType().equals("student")){

            System.out.println("\nType was student");
//            studentService.save(request.toStudent());


            Student newStudent = new Student();
            System.out.println("Student created: " + newStudent.toString());

            System.out.println("\nTrying to change req to student");
            newStudent = request.toStudent();

            System.out.println("checking for supervisor");
            if (newStudent.getsId() != -1){
                System.out.println("sId wasnt -1");
                newStudent.setSupervisor(supervisorService.findById(newStudent.getsId()).get());
            } else {
                System.out.println("sId was null");
            }

//            System.out.println("Checking if supervisor is null, its: " + newStudent.getSupervisor());
//            if (newStudent.getSupervisor() == null) {
//                System.out.println("Trying to find a supervisor with id: " + newStudent.getSupervisor().getSupervisorId());
//                System.out.println("found: " + supervisorService.findById(newStudent.getSupervisor().getSupervisorId()).get().toString());
//                newStudent.setSupervisor(supervisorService.findById(newStudent.getSupervisor().getSupervisorId()).get());
//            }
            System.out.println("Result was " +newStudent.toString());

            System.out.println("\nTrying to save this student to db");
            newStudent = studentService.save(newStudent);
            System.out.println("student was saved as " + newStudent.toString());

        } else if (request.getType().equals("supervisor")){
            System.out.println("\nType was supervisor");
            Supervisor newSupervisor = supervisorService.save(request.toSupervisor());
            System.out.println("Supervisor was saved as:\n" + newSupervisor.toString());
        } else {
            System.out.println("Person was neither supervisor nor student");
        }

//        result.setMessage("Person added...");

        return ResponseEntity.ok(request);
    }

}
