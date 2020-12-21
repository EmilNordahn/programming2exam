package emilnordahn.programming2exam.controller;

import emilnordahn.programming2exam.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @Autowired
    StudentService studentService;

    @GetMapping("/")
    public String index(Model model){
        System.out.println("\nRunning index from homecontroller\n");
        model.addAttribute("students", studentService.findAll().toArray());
        return "index";
    }

}
