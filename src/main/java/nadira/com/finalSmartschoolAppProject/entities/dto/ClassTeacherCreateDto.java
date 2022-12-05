package nadira.com.finalSmartschoolAppProject.entities.dto;

import lombok.Data;

@Data
public class ClassTeacherCreateDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int phoneNumber;
    private Long resultsId;
    private Long classTeacherId;
}
