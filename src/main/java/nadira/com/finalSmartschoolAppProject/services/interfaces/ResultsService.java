package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.entities.Student;

import java.util.ArrayList;
import java.util.List;

public interface ResultsService {

    List<Results> getAllResults();

    Results saveResults(Results results);

    Results updateResults(Results results);

    void deleteResultsById(Long id);

    Results getResultsById(Long id);

    Results getResultsByStudent(Student student);
}
