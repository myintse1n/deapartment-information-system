package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.Subject;

public interface SubjectRepo extends JpaRepositoryImplementation<Subject, Integer> {

	@Query("SELECT s FROM Subject s WHERE s.teacher.name = ?1 AND s.year.id = ?2")
	List<Subject> findByTeacherIdAndYearId(String teacher, Integer year);
	
	List<Subject> findByTeacherId(int id);
}
