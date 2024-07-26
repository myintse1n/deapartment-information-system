package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer> {
	@Query(value = """
			select t from Teacher t inner join Subject s where s.year.id=?1
			""")
	List<Teacher> findByYearId(Integer yearId);
}
