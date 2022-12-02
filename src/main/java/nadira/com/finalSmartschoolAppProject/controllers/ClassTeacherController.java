package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentInfoService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


@Controller
@RequestMapping("/classTeacher")
public class ClassTeacherController {

    private static Long studentId;
    @Autowired
    private StudentInfoService studentInfoService;
    @Autowired
    private ClassTeacherService classTeacherService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private ResultsService resultsService;


@GetMapping("/classteacher_home")
    public String classTeacherPage(Model model, HttpServletResponse response, HttpServletRequest request){
    try{
        ClassTeacher sessionClassTeacher = (ClassTeacher) request.getSession().getAttribute("classTeacher");
        if(sessionClassTeacher !=null){
            Cookie cookie1 = new Cookie("UserInfo", sessionClassTeacher.getFirstName());
            cookie1.setMaxAge(1 * 24 * 60 * 60);
            cookie1.setSecure(false);
            cookie1.setHttpOnly(false);
            response.addCookie(cookie1);

            Cookie cookie2 = new Cookie("Role","ClassTeacher");
            cookie2.setMaxAge(1 * 24 * 60 * 60);
            cookie2.setSecure(false);
            cookie2.setHttpOnly(false);
            response.addCookie(cookie2);

            List<Student> students = studentService.getAllStudents();
            students = studentService.getAllStudents();
            model.addAttribute("students", students);
            return "teacherStudentCreate";
        } else {
            return "redirect:/login/Authorization";
        }
    } catch(Exception e){
        return "redirect:/classTeacher/classteacher_home";
    }

}


}




