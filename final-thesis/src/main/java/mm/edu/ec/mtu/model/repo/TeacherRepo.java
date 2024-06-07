package mm.edu.ec.mtu.model.repo;


import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.Teacher;

public interface TeacherRepo extends JpaRepositoryImplementation<Teacher, Integer>{
	
}
