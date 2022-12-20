package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Student;

import java.util.List;

public interface ClassTeacherService {

    List<ClassTeacher> getAllClassTeacher();

    ClassTeacher getClassTeacherById(Long id);

    ClassTeacher saveClassTeacher(ClassTeacher classTeacher);

    ClassTeacher updateClassTeacher(ClassTeacher classTeacher);

    ClassTeacher getClassTeacherByEmailAndPassword(String email, String password);



    void deleteById(Long id);
}
