package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;

import java.util.List;

public interface StudentInfoService {

  List<StudentInfo> getAllStudentInfo();
  StudentInfo saveStudentInfo(StudentInfo   info);
  StudentInfo getStudentInfoById(Long id);
  StudentInfo updateStudentInfo(StudentInfo  info  );
  void deleteStudentInfoById(Long id);
  List<StudentInfo> getStudentInfoByStudentId(Long student_id);



}
