package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
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


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @Autowired
    private ResultsService resultsService;
    private Student student;
    @Autowired
    private ParentService parentService;
    @Autowired
    private ClassTeacherService classTeacherService;


    @GetMapping("/getStudentPage")
    public String getStudent(Model model, HttpServletRequest request, HttpServletResponse response) {
        Student studentSession = (Student) request.getSession().getAttribute("student");
        if (studentSession != null) {
            String name = studentSession.getEmail() + "/" + studentSession.getPassword();
            Student student = studentService.getStudentById(studentSession.getId());
            model.addAttribute("student", student);
            return "student_home";
        } else {
            return "redirect:/login/Authorization";
        }
    }

    @GetMapping("/students")
    public String listStudents(Model model, HttpSession session) {

        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("parent");
        if (user instanceof ClassTeacher) {
            model.addAttribute("students", studentService.getAllStudents());

            return "students";
        } else if (user2 instanceof Parent) {
            Student student = ((Parent) user2).getStudent();
            model.addAttribute("students", studentService.getStudentById(student.getId()));
        }

        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model, HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Student student = new Student();
        if (user instanceof ClassTeacher) {
            model.addAttribute("student", student);
            return "create_student";

        }
        return "error";
    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student, @ModelAttribute("classTeacher_id") Long id) {
        System.out.println(id);
        ClassTeacher classTeacher = classTeacherService.getClassTeacherById(id);
        System.out.println(classTeacher.getFirstName());// + "NADIRA");
        student.setClassTeacher(classTeacher);
        studentService.saveStudent(student);

        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model, HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("parent");

        if (user instanceof ClassTeacher) {
            model.addAttribute("student", studentService.getStudentById(id));
            return "edit_student";
        } else if (user2 instanceof Parent) {
            model.addAttribute("student", studentService.getAllStudents());
            System.err.println("Current User has no permissions");
            return "error";

        } else {
            return "error";
        }
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
        existingStudent.setGender(student.getGender());
        existingStudent.setGrade(student.getGrade());
        existingStudent.setClassTeacher(student.getClassTeacher());
        studentService.updateStudent(existingStudent);
        return "redirect:/students";

    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id,Model model,HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("parent");
        if (user instanceof ClassTeacher) {
            studentService.deleteStudentById(id);
            return "redirect:/students";
        } else if (user2 instanceof Parent) {
            System.err.println("Current User has no permissions");
            return "error";
        } else {
            return "error";
        }
    }
}




