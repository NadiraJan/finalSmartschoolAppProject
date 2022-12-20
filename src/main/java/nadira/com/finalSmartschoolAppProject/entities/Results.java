package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Results {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private double maxPoint;
    @Enumerated(EnumType.STRING)
    @Column(length = 255, nullable = false)
    private Subjects subjects;
    private String remarks;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;


}
