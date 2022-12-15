package nadira.com.finalSmartschoolAppProject.controllers;


import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Student;

import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegisterController {

@Autowired
  private StudentService studentService;


    @GetMapping("/register")
    public String getRegisterStudent(Model model) {
      Student student = new Student();
        model.addAttribute("student",student);
        return "register";

    }

    @PostMapping("/register")
    public String registerNewStudent(Student student) {

        studentService.saveStudent(student);
        return "redirect:/";

    }


}
