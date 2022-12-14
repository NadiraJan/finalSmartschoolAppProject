package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.dto.LoginDto;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ParentService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassTeacherService classTeacherService;
    @Autowired
    private ParentService parentService;

    @GetMapping("/getLogin")
    public String login(Model model, @ModelAttribute("login") LoginDto loginDto) {
        model.addAttribute("login", loginDto);
        return "login";

    }

    @PostMapping("/postLogin")
    public String login(@ModelAttribute LoginDto loginDto, HttpSession session, HttpServletResponse response) {

        if (loginDto.getRole().equals("student")) {

            List<Student> students = studentService.getAllStudents();

            for (Student student : students) {
                //     System.out.println(student.getEmail() + student.getPassword());
                //    System.out.println(loginDto.getEmail() + loginDto.getPassword());
                if (student.getEmail().equals(loginDto.getEmail()) && student.getPassword().equals(loginDto.getPassword())) {
                    session.setAttribute("student", student);
                    return "redirect:/getStudentPage";
                }
            }
        } else if (loginDto.getRole().equals("classTeacher")) {
            List<ClassTeacher> classTeacherList = classTeacherService.getAllClassTeacher();
            for (ClassTeacher classTeacher : classTeacherList) {
                System.out.println(classTeacher.getEmail() + classTeacher.getPassword());
                System.out.println(loginDto.getEmail() + loginDto.getPassword());
                if (classTeacher.getEmail().equals(loginDto.getEmail()) && classTeacher.getPassword().equals(loginDto.getPassword())) {
                    session.setAttribute("classTeacher", classTeacher);
                    return "redirect:/getClassTeacherPage";

                }
            }

        } else if (loginDto.getRole().equals("parent")) {
            List<Parent> parents = parentService.getAllParents();
            for (Parent parent : parents) {
                if (parent.getEmail().equals(loginDto.getEmail()) && parent.getPassword().equals(loginDto.getPassword())) {
                    session.setAttribute("parent", parent);
                    return "redirect:/getParentPage";
                }
            }
        }
        return "redirect:/login?error";
    }


    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.setAttribute("loginDto", null);
        session.invalidate();
        return "redirect:/login";
    }

    @GetMapping("/Authorization")
    public String getAuthErrorPage() {
        return "authErrorPage";
    }


}
