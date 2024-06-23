package mm.edu.ec.mtu.model.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mm.edu.ec.mtu.model.entity.Student;
import mm.edu.ec.mtu.model.repo.StudentRepo;
import mm.edu.ec.mtu.model.service.dto.StudentSignUpForm;
import mm.edu.ec.mtu.model.service.exception.BusinessException;

@Service
@Transactional(readOnly = true)
public class StudentService {

	@Autowired
	private StudentRepo repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	public Optional<Student> findByEmail(String email) {
		return repo.findById(email);
	}

	@Transactional
	public void create(StudentSignUpForm form) {
		if(repo.findById(form.getEmail()).isPresent()) {
			throw new BusinessException("Your email has already been used.");
		}
		
		var student = new Student();
		student.setEmail(form.getEmail());
		student.setName(form.getName());
		student.setPassword(encoder.encode(form.getPassword()));
		
		repo.save(student);
	}
	
	
}
