package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Student;

import java.util.List;

public interface ParentService {

    Parent getParentByEmailAndPassword(String email, String password);

    List<Parent> getAllParents();

    Parent getParentById(Long id);

    List<Parent> getParentByStudent(Student student);

}

