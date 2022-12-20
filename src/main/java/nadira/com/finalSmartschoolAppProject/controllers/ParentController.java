package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ParentService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.List;

@Controller
public class ParentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResultsService resultsService;

    @GetMapping("/getParentPage")
    public String getParent(Model model, HttpServletRequest request, HttpServletResponse response) {
        Parent parentSession = (Parent) request.getSession().getAttribute("parent");
        if (parentSession != null) {
            String name = parentSession.getEmail() + "/" + parentSession.getPassword();
            Parent parent = parentService.getParentById(parentSession.getId());
            model.addAttribute("parent", parent);
            return "parent_home";
        } else {
            return "redirect:/login/Authorization";
        }
    }


   @GetMapping("/parent/{results}")
   public String showTestResults(Model model,@PathVariable Long id){
       Student student = studentService.getStudentById(id);

       List<Results> resultsList = resultsService.getResultsByStudent(student);
       model.addAttribute("parent",resultsService.getResultsByStudent(student));

       return "results";

   }
   @GetMapping("/parent/{student_id}")
   public String showStudentById(Model model, @PathVariable()Long id){
       Student student = studentService.getStudentById(id);
       model.addAttribute("students", parentService.getParentByStudent(student));
       return "students";
   }


    @GetMapping("/parents")
    public String listParents(Model model, HttpSession session) {
        Object member = session.getAttribute("classTeacher");
        if (member instanceof ClassTeacher) {
            model.addAttribute("parents", parentService.getAllParents());

        }
        return "parents";

    }

    @GetMapping("/parent/new")
    public String createParentForm(Model model){
        Parent parent = new Parent();
        model.addAttribute("parent",parent);
        return "create_parent";

    }
    @PostMapping("/parents")
    public String saveParent(@ModelAttribute("parent")Parent parent, @ModelAttribute ("student_id")Long id){
        System.out.println(id);
        Student student = studentService.getStudentById(id);

        parent.setStudent(student);

        parentService.saveParent(parent);
        return "redirect:/parents";
    }



}