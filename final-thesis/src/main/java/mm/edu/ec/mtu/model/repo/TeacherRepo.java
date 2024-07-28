package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;

import mm.edu.ec.mtu.model.dto.TeachersByYear;
import mm.edu.ec.mtu.model.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer> {
	 @Query("SELECT t.id, t.name " +
	           "FROM Teacher t " +
	           "JOIN t.subjects s " +
	           "JOIN s.year y " +
	           "WHERE y.id = :yearId")
	    List<TeachersByYear> findByYearId(@Param("yearId") int yearId);
}
