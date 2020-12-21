package emilnordahn.programming2exam.controller;

import emilnordahn.programming2exam.model.Supervisor;
import emilnordahn.programming2exam.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SupervisorController {
    @Autowired
    SupervisorService supervisorService;

    @GetMapping("/showStudents/{supervisorId}")
    public String showStudents(@PathVariable("supervisorId") Long supervisorId, Model model){
        Supervisor supervisor = supervisorService.findById(supervisorId).get();
        model.addAttribute("students", supervisor.listStudents());
        model.addAttribute("supervisor", supervisor);
        return "supervisor/showStudents";
    }

    @PostMapping("/saveSupervisor")
    public String saveSupervisor(@ModelAttribute Supervisor supervisor){
        supervisorService.save(supervisor);
        return "redirect:/";
    }

    @GetMapping("deleteSupervisor/{supervisorId}")
    public String deleteSupervisor(@PathVariable("supervisorId") Long supervisorId){
        supervisorService.deleteById(supervisorId);
        return "redirect:/";
    }

    @GetMapping("saveSupervisor/{supervisorId}")
    public String saveSupervisor(Model model, @PathVariable("supervisorId") Long supervisorId){
        model.addAttribute("supervisor", supervisorService.findById(supervisorId).get());

        return "supervisor/updateSupervisor";
    }
}
