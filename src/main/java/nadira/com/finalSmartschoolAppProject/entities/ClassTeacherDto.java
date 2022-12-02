package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

import java.util.List;

@Data
public class ClassTeacherDto {
    public ClassTeacher classTeacher;
    public List<Results> results;
}
