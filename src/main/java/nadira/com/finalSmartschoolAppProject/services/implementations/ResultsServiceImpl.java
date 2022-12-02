package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.Results;
import nadira.com.finalSmartschoolAppProject.repositories.ResultsRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.ResultsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultsServiceImpl implements ResultsService {

    @Autowired
    private ResultsRepository resultsRepository;


    @Override
    public Results saveResults(Results results) {
        return resultsRepository.save(results);
    }

    @Override
    public Results updateResults(Results results) {
        return resultsRepository.save(results);
    }

    @Override
    public void deleteResultsById(Long id) {
        resultsRepository.deleteById(id);
    }


}
