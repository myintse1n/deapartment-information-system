package mm.edu.ec.mtu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import mm.edu.ec.mtu.model.repo.TeacherRepo;

@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private TeacherRepo teacherRepo;
	
	
	@GetMapping
	String home(ModelMap model){
		model.put("teacherList", teacherRepo.findAll());
		return "home";
	}
	
	@GetMapping("teachers")
	String teachers(ModelMap model){
		model.put("teacherList", teacherRepo.findAll());
		return "teachers";
	}
	
	@GetMapping("department-info")
	String info() {
		return "department-info";
	}
}
