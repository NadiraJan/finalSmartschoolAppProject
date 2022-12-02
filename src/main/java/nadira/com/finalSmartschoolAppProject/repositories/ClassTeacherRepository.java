package nadira.com.finalSmartschoolAppProject.repositories;

import nadira.com.finalSmartschoolAppProject.entities.ClassTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassTeacherRepository extends JpaRepository<ClassTeacher,Long> {

    ClassTeacher findByEmailAndPassword(String email, String password);
}
