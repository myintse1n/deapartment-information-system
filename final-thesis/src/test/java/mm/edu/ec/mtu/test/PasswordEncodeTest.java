package mm.edu.ec.mtu.test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import mm.edu.ec.mtu.model.entity.Admin.Role;

public class PasswordEncodeTest {
	public static void main(String[] args) {
		
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("admin"));
		System.out.println(Role.Admin.getClass());
		System.out.println();
	}
}
