package mm.edu.ec.mtu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import mm.edu.ec.mtu.model.service.security.AdminUserDetailsService;
import mm.edu.ec.mtu.model.service.security.StudentUserDetailsService;

@Configuration
public class WebSecurityAuthenticationProvider {

	@Autowired
	private AdminUserDetailsService adminUserDetailsService;
	
	@Autowired
	private StudentUserDetailsService studentUserDetailsService;
	
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	AuthenticationProvider getAdminAuthenticationProvider(PasswordEncoder encoder) {
		var provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(encoder);
		provider.setUserDetailsService(adminUserDetailsService);
		return provider;
	}
	
	@Bean
	AuthenticationProvider getStudetnAuthenticationProvider(PasswordEncoder encoder) {
		var provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(studentUserDetailsService);
		provider.setPasswordEncoder(encoder);
		return provider;
	}
}
