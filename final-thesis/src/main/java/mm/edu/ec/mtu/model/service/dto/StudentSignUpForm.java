package mm.edu.ec.mtu.model.service.dto;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StudentSignUpForm {
	
	@NotBlank(message = "Please enter student name")
	private String name;
	@NotBlank(message = "Please enter email")
	@Email(message = "Please enter valid email address")
	private String email;
	@NotBlank(message = "Please enter password")
	private String password;
	
	public Authentication authentication() {
		return UsernamePasswordAuthenticationToken.unauthenticated(email,password);
	}
}
