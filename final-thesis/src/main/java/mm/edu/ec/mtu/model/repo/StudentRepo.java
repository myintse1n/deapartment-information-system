package mm.edu.ec.mtu.model.repo;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.entity.Student;

public interface StudentRepo extends JpaRepositoryImplementation<Student, String> {

}
