package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.Appointment;
import nadira.com.finalSmartschoolAppProject.repositories.AppointmentRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;



    @Override
    public List<Appointment> getAll() {
        return appointmentRepository.findAll();
    }

    @Override
    public Appointment create(Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment update(Long appointmentId, Appointment appointment) {
        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment updateStatus(Long appointmentId, Appointment appointment) {

        Optional<Appointment> appointmentList = appointmentRepository.findById(appointmentId);

        if(appointmentList.isPresent()){
            if(appointment.getBooked() != null){
                appointmentList.get().setBooked(appointment.getBooked());
            }
            return appointmentRepository.save(appointmentList.get());
        }
        return null;
    }

    @Override
    public void deleteById(Long appointmentId) {

        appointmentRepository.deleteById(appointmentId);

    }

    @Override
    public void save(Appointment appointment) {
        appointmentRepository.save(appointment);
    }
}
