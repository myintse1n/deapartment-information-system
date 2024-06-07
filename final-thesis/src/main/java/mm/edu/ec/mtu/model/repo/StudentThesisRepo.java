package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.AcademicYear;
import mm.edu.ec.mtu.model.entity.StudentThesis;

public interface StudentThesisRepo extends JpaRepositoryImplementation<StudentThesis, Integer> {
	 List<StudentThesis> findAllByAcademicYear(AcademicYear academicYear);
}
