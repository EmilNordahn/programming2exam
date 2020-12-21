package emilnordahn.programming2exam.controller;

import emilnordahn.programming2exam.service.StudentService;
import emilnordahn.programming2exam.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    @Autowired
    SupervisorService supervisorService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("supervisors", supervisorService.findAllByOrderByLastNameAscFirstNameAsc());
        model.addAttribute("students", studentService.findAllByOrderByLastNameAscFirstNameAsc());
        return "index";
    }

}
