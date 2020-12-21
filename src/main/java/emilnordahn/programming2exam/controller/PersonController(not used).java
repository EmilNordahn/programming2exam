//Mislykket forsøg på at lave en RestController, jeg kunne få den til at oprette
//Students men kunne ikke få dem vist på siden uden at refreshe hele siden
//
//
//package emilnordahn.programming2exam.controller;
//
//import emilnordahn.programming2exam.model.Student;
//import emilnordahn.programming2exam.model.Supervisor;
//import emilnordahn.programming2exam.service.StudentService;
//import emilnordahn.programming2exam.service.SupervisorService;
//import emilnordahn.programming2exam.service.utility.AJAXrequest;
//import emilnordahn.programming2exam.service.utility.Result;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//public class PersonController {
//    @Autowired
//    private StudentService studentService;
//
//    @Autowired
//    private SupervisorService supervisorService;
//
//    public PersonController(StudentService studentService, SupervisorService supervisorService){
//        this.studentService = studentService;
//        this.supervisorService = supervisorService;
//    }
//
//    @PostMapping("api/getStudents")
//    public ResponseEntity<Object[]> getSearchStudentsResult(){
//        System.out.println("api/getStudents called");
//        return ResponseEntity.ok(studentService.findAll().toArray());
//    }
//
//    @PostMapping("api/add")
//    public ResponseEntity<Result> getAddResult(@RequestBody AJAXrequest request) {
//        System.out.println("api/add was called with: " + request.toString());
//
//        Result  result = new Result();
//
//        if (request.getType().equals("student")){
//
//            System.out.println("\nType was student");
//            studentService.save(request.toStudent());
//
//
////            Student newStudent = new Student();
////            System.out.println("Student created: " + newStudent.toString());
////
////            System.out.println("\nTrying to change req to student");
////            newStudent = request.toStudent();
////            System.out.println("Result was " +newStudent.toString());
////
////            System.out.println("\nTrying to save this student to db");
////            newStudent = studentService.save(newStudent);
////            System.out.println("student was saved as " + newStudent.toString());
//
//        } else if (request.getType().equals("supervisor")){
//            System.out.println("\nType was supervisor");
//            Supervisor newSupervisor = supervisorService.save(request.toSupervisor());
//            System.out.println("Supervisor was saved as:\n" + newSupervisor.toString());
//        } else {
//            System.out.println("Person was neither supervisor nor student");
//        }
//
//        result.setMessage("Person added...");
//
//        return ResponseEntity.ok(result);
//    }
//
//}
