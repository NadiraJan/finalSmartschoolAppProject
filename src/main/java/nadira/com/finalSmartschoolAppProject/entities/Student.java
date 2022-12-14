package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Student extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int age;
    private String gender;
    private String grade;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "classTeacher_id", nullable = true)
    private ClassTeacher classTeacher;


    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    private List<Results> results;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private Parent parent;


}
