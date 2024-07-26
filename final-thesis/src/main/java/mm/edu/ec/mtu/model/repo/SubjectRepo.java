package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.dto.SubjectByTeacheNameAndStuYear;
import mm.edu.ec.mtu.model.entity.Subject;

public interface SubjectRepo extends JpaRepositoryImplementation<Subject, Integer>{
	
	@Query(value = """
			select s.name name,s.code code, s.teacher.name teacherName, s.feedbacks feedback  from Subject s 
			where s.teacher.name = ?1 and s.year.currentYear= ?2
			""")
	List<SubjectByTeacheNameAndStuYear> findSubjectByTnameAndSyear(String teacher,String year);
	
	@Query(nativeQuery = true,
			value = "select *  from subject s inner join student_year y on s.year_id=y.id where y.id=?"
			)
	List<Subject> findByYearId(Integer yearId);

}
