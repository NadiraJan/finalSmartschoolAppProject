package nadira.com.finalSmartschoolAppProject.entities.dto;

import lombok.Data;
import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;

import java.util.List;

@Data
public class StudentInfoDto {
    public List<Student> students;
    public ClassTeacher classTeacher;
    public List<StudentInfo>studentInfo;
}
