package mm.edu.ec.mtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	
	
	@GetMapping
	String home(ModelMap model){
		return "home";
	}
	
	@GetMapping("department-info")
	String info() {
		return "department-info";
	}
}
