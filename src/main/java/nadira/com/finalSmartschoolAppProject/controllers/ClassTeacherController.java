package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentInfoService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller

public class ClassTeacherController {


    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private ClassTeacherService classTeacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResultsService resultsService;


    @GetMapping("/getClassTeacherPage")
    public String getClassTeacher(Model model, HttpServletRequest request, HttpServletResponse response) {
        ClassTeacher classTeacherSession = (ClassTeacher) request.getSession().getAttribute("classTeacher");
        if (classTeacherSession != null) {
            String name = classTeacherSession.getEmail() + "/" + classTeacherSession.getPassword();
            ClassTeacher classTeacher = classTeacherService.getClassTeacherById(classTeacherSession.getId());
            model.addAttribute("classTeacher", classTeacher);
            return "classteacher_home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/classTeacher")
    public String listClassTeacher(Model model) {
        model.addAttribute("classTeacher", classTeacherService.getAllClassTeacher());
        return "classTeacher";

    }

 /*   @GetMapping("/classTeacher/{id}")
    public String ClassTeacherById(Model model, @PathVariable Long id) {
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);
        model.addAttribute("classTeacher", id);
        return "classTeacher" + id;

    }

    @PostMapping("/classTeacher")
    public String saveClassTeacher(@ModelAttribute("classTeacher") ClassTeacher classTeacher) {
        classTeacherService.saveClassTeacher(classTeacher);
        return "redirect:/classTeacher";

    }*/


}




