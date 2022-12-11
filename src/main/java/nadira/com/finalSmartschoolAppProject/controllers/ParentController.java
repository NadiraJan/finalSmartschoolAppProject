package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ParentService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class ParentController {
    @Autowired
    private ParentService parentService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/getParentPage")
    public String getParent(Model model, HttpServletRequest request, HttpServletResponse response){
        Parent parentSession = (Parent) request.getSession().getAttribute("parent");
        if(parentSession !=null){
            String name= parentSession.getEmail() + "/" + parentSession.getPassword();
            Parent parent = parentService.getParentById(parentSession.getId());
            model.addAttribute("parent", parent);
            return "parent_home";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/parents/{studentId}")
    public String getAllParentsByStudent(Model model, @PathVariable Long student_id){
        Student student = studentService.getStudentById(student_id);
        List<Parent> parents = parentService.getParentByStudent(student);
        model.addAttribute("parents", parents);

        return "parents";


    }




}
