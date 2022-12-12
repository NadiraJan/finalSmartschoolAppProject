package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.Appointment;
import nadira.com.finalSmartschoolAppProject.entities.Student;

import java.util.List;


public interface AppointmentService {



    List<Appointment> getAll();

    Appointment create(Appointment appointment);

    Appointment update(Long appointmentId, Appointment appointment);

    Appointment updateStatus(Long appointmentId, Appointment appointment);

    void deleteById(Long appointmentId);

    void save(Appointment appointment);


}