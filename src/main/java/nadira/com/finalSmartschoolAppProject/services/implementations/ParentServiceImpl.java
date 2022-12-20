package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Parent;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.repositories.ParentRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ParentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParentServiceImpl implements ParentService {
    @Autowired
    private ParentRepository parentRepository;


    @Override
    public Parent getParentByEmailAndPassword(String email, String password) {
        return parentRepository.findByEmailAndPassword(email, password);
    }

    @Override
    public List<Parent> getAllParents() {
        return parentRepository.findAll();
    }

    @Override
    public Parent getParentById(Long id) {
        return parentRepository.findById(id).get();
    }

    @Override
    public List<Parent> getParentByStudent(Student student) {
        return parentRepository.findByStudent(student);
    }

    @Override
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public Parent saveParent(Parent parent) {
        return parentRepository.save(parent);
    }


}
