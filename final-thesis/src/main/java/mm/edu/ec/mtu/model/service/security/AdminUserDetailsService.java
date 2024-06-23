package mm.edu.ec.mtu.model.service.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import mm.edu.ec.mtu.model.entity.Admin;
import mm.edu.ec.mtu.model.service.AdminService;

@Service
public class AdminUserDetailsService implements UserDetailsService {

	@Autowired
	private AdminService service;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Admin> result = service.findByUsername(email);
		return result.map(admin-> User.withUsername(email)
				.authorities("Admin")
				.password(admin.getPassword())
				.build())
				.orElseThrow(()->new UsernameNotFoundException(email));
	}

}
