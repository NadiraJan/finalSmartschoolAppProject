package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;

import java.util.List;

public interface StudentInfoService {

  List<StudentInfo> getAllStudentInfo();
  StudentInfo saveStudentInfo(StudentInfo studentInfo);
  StudentInfo getStudentInfoById(Long id);
  StudentInfo updateStudentInfo(StudentInfo studentInfo);
  void deleteStudentInfoById(Long id);
  StudentInfo getStudentInfoByStudentId(Long studentId);



}
