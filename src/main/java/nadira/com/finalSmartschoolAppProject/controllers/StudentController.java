package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.entities.Student;
//import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;
//import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
//import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentInfoService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ParentService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.apache.catalina.filters.ExpiresFilter;
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
import java.util.List;

@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
  //  @Autowired
    //private StudentInfoService studentInfoService;
    @Autowired
    private ResultsService resultsService;
    private Student student;
    @Autowired
    private ParentService parentService;


    @GetMapping("/getStudentPage")
    public String getStudent(Model model, HttpServletRequest request, HttpServletResponse response){
        Student studentSession = (Student) request.getSession().getAttribute("student");
        if(studentSession !=null){
            String name= studentSession.getEmail() + "/" + studentSession.getPassword();
            Student student = studentService.getStudentById(studentSession.getId());
            model.addAttribute("student", student);
            return "student_home";
        } else {
            return "redirect:/login";
        }
    }

 /*   @GetMapping("/getStudentInfoPage/{student_id}")
    public String getStudentInfo(@PathVariable("student_id") Long student_id, Model model,HttpServletRequest request) {
        Student studentSession = (Student) request.getSession().getAttribute("student");
        if (studentSession != null) {
            if (student_id == studentSession.getId()) {
                Student student = studentService.getStudentById(studentSession.getId());
                List<StudentInfo> studentInfo = studentInfoService.getStudentInfoByStudentId(studentSession.getId());
                model.addAttribute("studentInfo", studentInfo);
                return "studentInfo_home";
            }
            return "redirect:/student/getStudentPage";
        } else {
            return "redirect:/login";
        }

    }*/

    @GetMapping("/students")
    public String listStudents(Model model,HttpSession session) {

        Object user = session.getAttribute("classTeacher");

       if (user instanceof ClassTeacher) {
            model.addAttribute("students", studentService.getAllStudents());
        }
        return "students";
    }

   @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";

    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";


    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("student") Student student,
                                Model model) {

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setPassword(student.getPassword());
        existingStudent.setAge(student.getAge());
        existingStudent.setGrade(student.getGender());
        existingStudent.setGrade(student.getGrade());
        existingStudent.setClassTeacher(student.getClassTeacher());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";

    }





}







