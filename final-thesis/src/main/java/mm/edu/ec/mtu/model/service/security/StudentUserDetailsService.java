package mm.edu.ec.mtu.model.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mm.edu.ec.mtu.model.entity.Admin.Role;
import mm.edu.ec.mtu.model.service.StudentService;

@Service
public class StudentUserDetailsService implements UserDetailsService{

	@Autowired
	private StudentService service;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	
		return service.findByEmail(email)
				.map(student->User.withUsername(email)
						.authorities(Role.Student.name())
						.password(student.getPassword())
						.build())
				.orElseThrow(()-> new UsernameNotFoundException(email));
	}

}
