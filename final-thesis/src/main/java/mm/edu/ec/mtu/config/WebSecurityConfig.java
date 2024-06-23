package mm.edu.ec.mtu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.security.web.context.SecurityContextRepository;

import mm.edu.ec.mtu.model.entity.Admin.Role;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Autowired
	private AuthenticationProvider getAdminAuthenticationProvider;
	
	@Autowired
	private AuthenticationProvider getStudetnAuthenticationProvider;

	@Bean
	SecurityFilterChain homeFilter(HttpSecurity http) throws Exception {
		
		http.securityMatcher("/").authorizeHttpRequests(request->{
			request.anyRequest().permitAll();
		});
		
		return http.build();
	}
	
	@Bean
	SecurityFilterChain resourcesFilter(HttpSecurity http) throws Exception {
		
		http.securityMatcher("/resources/**").authorizeHttpRequests(request->{
			request.anyRequest().permitAll();
		});
		
		return http.build();
	}
	
	@Bean
	SecurityFilterChain httpFilter(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(request->{
			request.requestMatchers("/login","/signup").permitAll();
			request.requestMatchers("/**").hasAnyAuthority(Role.Admin.name(),Role.Student.name());
		});
		http.formLogin(form->form.loginPage("/login"));
		http.logout(form->form.logoutSuccessUrl("/"));
		return http.build();
	}
	
	@Bean
	AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder encoder) throws Exception {
		var builder = http.getSharedObject(AuthenticationManagerBuilder.class);
		builder.authenticationProvider(getAdminAuthenticationProvider);
		builder.authenticationProvider(getStudetnAuthenticationProvider);
		return builder.build();
	}
	
	@Bean
	SecurityContextRepository securityContextRepository() {
		return new HttpSessionSecurityContextRepository();
	}
}
