package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Parent extends User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String relation;

    @OneToOne(fetch = FetchType.LAZY)
    private Student student;


}
