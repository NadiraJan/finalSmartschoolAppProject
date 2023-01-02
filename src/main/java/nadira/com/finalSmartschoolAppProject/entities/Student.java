package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Student extends User {

    @Id
    @SequenceGenerator(name = "sequence", sequenceName = "mySequence",allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(unique = true, updatable = false, nullable = false)
    private Long id;
    private int age;
    private String gender;
    private String grade;

    public Student() {
    }

    public Student(int age, String gender, String grade, ClassTeacher classTeacher) {
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.classTeacher = classTeacher;
    }

    public Student(String firstName, String lastName, String email, String password, int age, String gender, String grade, ClassTeacher classTeacher) {
        super(firstName, lastName, email, password);
        this.age = age;
        this.gender = gender;
        this.grade = grade;
        this.classTeacher = classTeacher;
    }

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "classTeacher_id")
    private ClassTeacher classTeacher;


    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    private List<Results> results;

    @OneToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "student")
    private Parent parent;


}
