package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class ClassTeacher extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private int phoneNumber;
    private String myWorkingDays;
    private String parentsContact;


    @OneToMany(mappedBy = "classTeacher",
            cascade = CascadeType.ALL, fetch = FetchType.LAZY)

    private Set<Student> students = new HashSet<>();


  /*  @ManyToOne
    @JoinColumn(name = "appointment_id")
    private Appointment appointment;*/

}
