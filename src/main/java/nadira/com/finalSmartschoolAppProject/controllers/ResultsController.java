package nadira.com.finalSmartschoolAppProject.controllers;
import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.entities.Student;
import nadira.com.finalSmartschoolAppProject.entities.Subjects;
import nadira.com.finalSmartschoolAppProject.entities.dto.LoginDto;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import nadira.com.finalSmartschoolAppProject.services.interfaces.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class ResultsController {
    @Autowired
    private ResultsService resultsService;
    @Autowired
    private StudentService studentService;

    @GetMapping("/results")
    public String listResults(Model model) {

        model.addAttribute("results", resultsService.getAllResults());
        return "results"; }


        @GetMapping("/results/new")
    public String createResultsForm(Model model){
        Results results = new Results();
        model.addAttribute("results", results);
        return "create_results";
    }


 @PostMapping("/results")
    public String saveResults(@ModelAttribute("results")Results results){
        resultsService.saveResults(results);
        return "redirect:/results";
    }

    @GetMapping("/results/edit/{id}")
    public String editResultsForm(@PathVariable Long id, Model model) {
        model.addAttribute("results", resultsService.getResultsById(id));
        return "edit_results";}

    @PostMapping("/results/{id}")
    public String updateResults(@PathVariable Long id,
                                @ModelAttribute("results") Results results,
                                Model model) {
        Results existingResults = resultsService.getResultsById(id);
        existingResults.setMaxPoint(results.getMaxPoint());
        existingResults.setSubjects(results.getSubjects());
        existingResults.setRemarks(results.getRemarks());
        resultsService.updateResults(existingResults);
        return "redirect:/results";


    }

    @GetMapping("/results/{id}")
    public String deleteResult(@PathVariable Long id) {
       resultsService.deleteResultsById(id);
        return "redirect:/results";

    }


 @GetMapping("/getResults")
    public String listResults(Model model, HttpSession httpSession) {
 //Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Object user = httpSession.getAttribute("student");

        if(user instanceof Student){
            model.addAttribute("results" ,
                    resultsService.getResultsByStudent(((Student)user)));
        } else if(user instanceof ClassTeacher){

            model.addAttribute("results", resultsService.getAllResults());
        }
        return "results";


    }


/* @GetMapping("/results/{studentId}")
    public String seeAllResultsByStudentId(Model model, @PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        Results results = resultsService.getResultsByStudent(student);
        model.addAttribute("results", results);
        model.addAttribute("results", new Results(0, Subjects.valueOf(""), "", student));

        return "results";
    }*/



}
