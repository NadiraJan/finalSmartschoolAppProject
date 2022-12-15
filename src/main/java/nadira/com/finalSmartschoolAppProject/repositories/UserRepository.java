package nadira.com.finalSmartschoolAppProject.repositories;


import nadira.com.finalSmartschoolAppProject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


@NoRepositoryBean
public interface UserRepository extends JpaRepository<User, Long> {
}
