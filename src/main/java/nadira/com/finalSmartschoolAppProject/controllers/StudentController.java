package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentInfoService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;


@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentInfoService studentInfoService;

 /*   @GetMapping("/getStudentPage")
    public String showStudent(Model model, HttpSession session){
        Student studentSession = (Student) session.getAttribute("student");
        if(studentSession !=null){
            String name= studentSession.getFirstName() +"/" + studentSession.getFirstName();
            Student student = studentService.getStudentById(studentSession.getId());
            model.addAttribute("student", student);
            return "studentShow";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/getStudentInfoPage/{studentId}")
    public String showStudentInfo(@PathVariable("studentId") Long studentId, Model model, HttpSession session){
        Student studentSession = (Student) session.getAttribute("student");
        if(studentSession !=null) {
            if (studentId == studentSession.getId()) {
                Student student = studentService.getStudentById(studentSession.getId());
                StudentInfo studentInfo = studentInfoService.getStudentInfoById(studentSession.getId());
                model.addAttribute("studentInfo", studentInfo);
                return "studentInfoShow";
            }
            return "redirect:/student/getStudentPage";
        } else {
            return "redirect:/login";
        }
        }

    @GetMapping("/student/home")
    public String viewStudentHomePage() {
        return "student/student_home";
    }



    @PostMapping("/login")
    public String login(@ModelAttribute("student") Student studentReceived, HttpSession httpSession) {
        System.out.println(studentReceived.getEmail());
        System.out.println(studentReceived.getPassword());

        Student foundStudent = studentService.getByEmailAndPassword(studentReceived.getEmail(),studentReceived.getPassword());

        if(foundStudent==null){
            System.out.println("no valid student");
            return "redirect:/student/login";
        }
        else {

            httpSession.setAttribute("loggedInUser", studentReceived);
            return "redirect:/student/home";
        }

    }*/



    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    //handler method to handle list of students and return mode and view
    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
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
        //  existingStudent.setId(id);
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




