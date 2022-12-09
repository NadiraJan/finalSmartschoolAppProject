package nadira.com.finalSmartschoolAppProject.services.implementations;

import nadira.com.finalSmartschoolAppProject.entities.TimeTable;
import nadira.com.finalSmartschoolAppProject.repositories.TimeTableRepository;
import nadira.com.finalSmartschoolAppProject.services.interfaces.TimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TimeTableServiceImpl implements TimeTableService {

    @Autowired
    TimeTableRepository timeTableRepository;


    @Override
    public void createTimeTable(TimeTable timeTable) {
         timeTableRepository.save(timeTable);
    }
}
