package nadira.com.finalSmartschoolAppProject.repositories;

import nadira.com.finalSmartschoolAppProject.entities.Results;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultsRepository extends JpaRepository<Results, Long> {
}
