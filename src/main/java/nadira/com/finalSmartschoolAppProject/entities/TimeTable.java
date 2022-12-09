package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table
public class TimeTable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 255, nullable = false)
    private Subjects subjects;

    @Enumerated(EnumType.STRING)
    @Column(length = 255, nullable = false)
    private Day day;

    private LocalTime beginTime;
    private LocalTime endTime;
    private int classRoomNumber;



}
