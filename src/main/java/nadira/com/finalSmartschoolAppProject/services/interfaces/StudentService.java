package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student saveStudent(Student student);

    Student getStudentById(Long id);

    Student updateStudent(Student student);

    void deleteStudentById(Long id);

    Student getByEmailAndPassword(String email, String password);





}
