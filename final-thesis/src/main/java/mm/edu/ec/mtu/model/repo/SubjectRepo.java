package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.dto.TeacherSubjectByYear;
import mm.edu.ec.mtu.model.entity.Subject;

public interface SubjectRepo extends JpaRepositoryImplementation<Subject, Integer> {

	List<Subject> findByYearId(int yearId);

	@Query(nativeQuery = true, value = """
			select t.name teacherName, s.name subjectName, y.current_year currentYear from subject s 
			inner join teacher t on s.teacher_id = t.id inner join student_year y on s.year_id = y.id where y.id=?;
			""")
	List<TeacherSubjectByYear> findByYear(int yearId);
}
