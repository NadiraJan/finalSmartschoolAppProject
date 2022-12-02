package nadira.com.finalSmartschoolAppProject.services.interfaces;

import nadira.com.finalSmartschoolAppProject.entities.Results;

public interface ResultsService {

    Results saveResults(Results results);
    Results updateResults(Results results);
    void  deleteResultsById(Long id);
}
