package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

import java.util.List;

@Data
public class StudentInfoDto {
    public List<Student> students;
    public ClassTeacher classTeacher;
    public List<StudentInfo>studentInfo;
}
