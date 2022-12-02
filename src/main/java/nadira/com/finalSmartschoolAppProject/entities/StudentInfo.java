package nadira.com.finalSmartschoolAppProject.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class StudentInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="studentInfoId")
    private Long studentId;

    private Long classTeacherId;
    private Long resultsId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "studentId", nullable = false)
    private Student student;

}
