package nadira.com.finalSmartschoolAppProject.entities.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {

    private String email;
    private String password;
    private String role;
}
