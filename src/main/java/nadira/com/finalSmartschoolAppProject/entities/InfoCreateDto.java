package nadira.com.finalSmartschoolAppProject.entities;

import lombok.Data;

@Data
public class InfoCreateDto {
    public InfoCreateDto(Long classTeacherId, Long resultsId) {



    }

    public Long classTeacherId;
    public Long ResultsId;

}



