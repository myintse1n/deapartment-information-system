package mm.edu.ec.mtu.test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class PasswordEncodeTest {
	public static void main(String[] args) {
		
		
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		System.out.println(encoder.encode("student"));
		System.out.println();
	}
}
