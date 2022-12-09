package nadira.com.finalSmartschoolAppProject.controllers;


import nadira.com.finalSmartschoolAppProject.services.interfaces.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeTableController {

    @Autowired
    private TimeTableService timeTableService;

    @GetMapping("/timetable")
    public String viewTimeTable(Model model) {
        return "timetable";
    }






}
