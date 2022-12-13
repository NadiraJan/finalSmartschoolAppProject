package nadira.com.finalSmartschoolAppProject.controllers;

import com.sun.mail.iap.Response;
import nadira.com.finalSmartschoolAppProject.entities.Appointment;
import nadira.com.finalSmartschoolAppProject.services.interfaces.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

import java.util.stream.Collectors;

/*@Controller
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;


    @RequestMapping(value = "/parent/makeAppointment/{id}/{classTeacherName}", method = RequestMethod.POST)
    @PreAuthorize("hasRole('parent')")
    public ResponseEntity<?> addAppointment(@RequestBody String appointment, @PathVariable String doctorName, @PathVariable Long id, Principal principal) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        List<Appointment> list = appointmentService.getAll();
        //list.stream().filter(a->a.getDate()==appointment);
        List<Appointment> existList = list.stream().filter(a -> a.getDate().equals(appointment)).collect(Collectors.toList());

        if (existList.size() < 1) {
            Appointment appointment1 = new Appointment();
            appointment1.setBooked("pending");
            appointment1.setDate(appointment);
            appointment1.setClassTeacherName("Lizz Trass");
            appointment1.setParentName(principal.getName());
            appointmentService.save(appointment1);
            return ResponseEntity.ok(new Response("Appointment was saved successfully!"));
        }
        return ResponseEntity.ok(new Response("Appointment was taken try another date"));
    }

    @GetMapping("/appointments")
    public String listStudents(Model model) {
        model.addAttribute("appointments", appointmentService.getAll());
        return "appoint";

    }

    @GetMapping("/appointment/new")
    public String createAppointmentForm(Model model) {
        Appointment appointment = new Appointment();
        model.addAttribute("appointment", appointment);
        return "appoint";

    }

    @PostMapping("/appointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment) {
        appointmentService.save(appointment);
        return "redirect:/students";

    }


}*/
