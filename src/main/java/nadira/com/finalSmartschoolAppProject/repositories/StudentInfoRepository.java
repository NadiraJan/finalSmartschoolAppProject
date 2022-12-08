package nadira.com.finalSmartschoolAppProject.repositories;

import nadira.com.finalSmartschoolAppProject.entities.StudentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentInfoRepository extends JpaRepository<StudentInfo, Long> {


    List<StudentInfo> findByStudentId(Long student_id);
}
