package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;
import nadira.com.finalSmartschoolAppProject.repositories.StudentInfoRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentInfoImpl implements StudentInfoService {

    @Autowired
    private StudentInfoRepository studentInfoRepository;


    @Override
    public List<StudentInfo> getAllStudentInfo() {
        return studentInfoRepository.findAll();
    }

    @Override
    public StudentInfo saveStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public StudentInfo getStudentInfoById(Long id) {
        return studentInfoRepository.findByStudentId(id);
    }


    @Override
    public StudentInfo updateStudentInfo(StudentInfo studentInfo) {
        return studentInfoRepository.save(studentInfo);
    }

    @Override
    public void deleteStudentInfoById(Long id) {
        studentInfoRepository.deleteById(id);

    }

    @Override
    public StudentInfo getStudentInfoByStudentId(Long studentId) {
        return studentInfoRepository.findByStudentId(studentId);
    }
}
