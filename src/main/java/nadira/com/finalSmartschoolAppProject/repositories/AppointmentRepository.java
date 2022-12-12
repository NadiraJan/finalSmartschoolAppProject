package nadira.com.finalSmartschoolAppProject.repositories;

import nadira.com.finalSmartschoolAppProject.entities.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
