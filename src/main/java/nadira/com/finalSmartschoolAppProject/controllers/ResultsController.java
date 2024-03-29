package nadira.com.finalSmartschoolAppProject.controllers;

import nadira.com.finalSmartschoolAppProject.entities.*;
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


 /*@GetMapping("/results")
    public String listResults(Model model) {
        model.addAttribute("results", resultsService.getAllResults());
        return "results";
    }*/

    @GetMapping("/results")
    public String listResults(Model model, HttpSession httpSession) {
        Object user = httpSession.getAttribute("student");
        Object user2 = httpSession.getAttribute("classTeacher");
        Object user3 = httpSession.getAttribute("parent");
        if (user instanceof Student) {
            model.addAttribute("results",
                    resultsService.getResultsByStudent(((Student) user)));
        } else if (user2 instanceof ClassTeacher) {

            model.addAttribute("results", resultsService.getAllResults());
        } else if (user3 instanceof Parent) {
            Student student = ((Parent) user3).getStudent();

            model.addAttribute("results",
                    resultsService.getResultsByStudent(student));
        }

        return "results";
    }


    @PostMapping("/results")
    public String saveResults(@ModelAttribute("results") Results results) {
        resultsService.saveResults(results);
        return "redirect:/results";
    }

    @GetMapping("/results/new")
    public String createResultsForm(Model model, HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("student");

        Results results = new Results();
        if (user instanceof ClassTeacher) {
            model.addAttribute("results", results);
            return "create_results";

        } else if (user2 instanceof Student) {

            System.err.println("Current User has no permissions");
            return "error";


        }
        return "error";

    }



 /*   @GetMapping("/results/edit/{id}")
    public String editResultsForm(@PathVariable Long id, Model model) {
        model.addAttribute("results", resultsService.getResultsById(id));
        return "edit_results";
    }*/

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

 /* @GetMapping("/results/new")
    public String createResultsForm(Model model) {
        Results results = new Results();
        model.addAttribute("results", results);
        return "create_results";
    }*/


 /*@GetMapping("/results/{id}")
    public String deleteResults(@PathVariable Long id) {
        resultsService.deleteResultsById(id);
        System.out.println(id + "nadira");
        return "redirect:/results";

    }*/

    @GetMapping("/results/edit/{id}")
    public String editResultsForm(@PathVariable Long id, Model model, HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("student");

        if (user instanceof ClassTeacher) {
            model.addAttribute("results", resultsService.getResultsById(id));
            return "edit_results";
        } else if (user2 instanceof Student) {
            model.addAttribute("results", resultsService.getAllResults());
            System.err.println("Current User has no permissions");
            return "error";

        } else {
            return "error";

        }

    }

    @GetMapping("/results/{id}")
    public String deleteResults(@PathVariable Long id, HttpSession session) {
        Object user = session.getAttribute("classTeacher");
        Object user2 = session.getAttribute("student");
        if (user instanceof ClassTeacher) {

            resultsService.deleteResultsById(id);
            return "redirect:/results";
        } else if (user2 instanceof Student) {
//            resultsService.deleteResultsById(id);
            System.err.println("Current User has no permissions to DELETE anything on results by id: ");
            return "error";

        } else {
            return "error";

        }

    }

}



