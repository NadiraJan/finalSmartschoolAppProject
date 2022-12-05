package nadira.com.finalSmartschoolAppProject.repositories;

import nadira.com.finalSmartschoolAppProject.entities.EmailMessage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailMessageRepository extends JpaRepository<EmailMessage,String> {
}
