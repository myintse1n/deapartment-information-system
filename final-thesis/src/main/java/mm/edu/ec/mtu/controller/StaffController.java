package mm.edu.ec.mtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("staff")
public class StaffController {
	@GetMapping
	String staff() {
		return "staff";
	}
}
