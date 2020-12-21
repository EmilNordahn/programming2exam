package emilnordahn.programming2exam.controller;

import emilnordahn.programming2exam.model.Student;
import emilnordahn.programming2exam.service.StudentService;
import emilnordahn.programming2exam.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    SupervisorService supervisorService;

    @GetMapping("/saveStudent/{studentId}")
    public String saveStudent(Model model, @PathVariable("studentId") Long studentId){
        Student student = studentService.findById(studentId).get();
        model.addAttribute("supervisors", supervisorService.findAllByOrderByLastNameAscFirstNameAsc());
        model.addAttribute("student", student);
        studentService.save(student);
        return "/student/updateStudent";
    }

    @PostMapping("/saveStudent")
    public String saveStudent(@ModelAttribute Student student, @RequestParam("supervisorId") Long supervisorId){
        if (supervisorService.findById(supervisorId).isPresent()) {
            student.setSupervisor(supervisorService.findById(supervisorId).get());
        }
        studentService.save(student);
        return "redirect:/";
    }

    @GetMapping("deleteStudent/{studentId}")
    public String deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteById(studentId);
        return "redirect:/";
    }
}
