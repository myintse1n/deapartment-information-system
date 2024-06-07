package mm.edu.ec.mtu.model.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.AcademicYear;

public interface AcademicYearRepo extends JpaRepositoryImplementation<AcademicYear, Integer> {
	Optional<AcademicYear> streamByYear(String year);
}
