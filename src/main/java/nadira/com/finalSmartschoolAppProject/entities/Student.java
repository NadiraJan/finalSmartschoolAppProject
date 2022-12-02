package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;
    private String gender;
    private String grade;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "classTeacher_id", nullable = true)
    private ClassTeacher classTeacher;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Results> results;

}
