package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;



@Setter
@Getter
@NoArgsConstructor
@MappedSuperclass
public abstract class User {
    @Id
    @SequenceGenerator(name="sequence",sequenceName = "userSequence")
            @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @Column(unique = true, updatable = false, nullable = false)


    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;


    public User(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
