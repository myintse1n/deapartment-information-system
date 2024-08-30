package mm.edu.ec.mtu.model.repo;

import java.util.List;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.StudentYear;

public interface StudentYearRepo extends JpaRepositoryImplementation<StudentYear, Integer>{
	
	List<StudentYear> findAllByOrderById();

}
