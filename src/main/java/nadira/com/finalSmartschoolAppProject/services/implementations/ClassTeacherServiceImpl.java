package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.repositories.ClassTeacherRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ClassTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassTeacherServiceImpl implements ClassTeacherService {

    @Autowired
    private ClassTeacherRepository classTeacherRepository;


    @Override
    public List<ClassTeacher> getAllClassTeacher() {
        return classTeacherRepository.findAll();
    }

    @Override
    public ClassTeacher getClassTeacherById(Long id) {
        return classTeacherRepository.findById(id).get();
    }

    @Override
    public ClassTeacher saveClassTeacher(ClassTeacher classTeacher) {
        return classTeacherRepository.save(classTeacher);
    }

    @Override
    public ClassTeacher updateClassTeacher(ClassTeacher classTeacher) {
        return classTeacherRepository.save(classTeacher);
    }


    @Override
    public ClassTeacher getClassTeacherByEmailAndPassword(String email, String password) {
        return classTeacherRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public void deleteById(Long id) {
        classTeacherRepository.deleteById(id);
    }


}
