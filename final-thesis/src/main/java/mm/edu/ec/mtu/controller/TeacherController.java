package mm.edu.ec.mtu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mm.edu.ec.mtu.model.entity.Teacher;
import mm.edu.ec.mtu.model.service.TeacherService;

@Controller
@RequestMapping("teachers")
public class TeacherController {

	@Autowired
	private TeacherService service;

	@GetMapping
	String teachers(@RequestParam(required = false) String keyword, ModelMap model) {
		model.put("teacherList", service.search(keyword));
		return "teachers";
	}

	@GetMapping("edit")
	String teacherEdit() {
		return "teacher-edit";
	}

	@PostMapping
	String save(@ModelAttribute("teacher") @Validated Teacher teacher, BindingResult result) {
		if (result.hasErrors()) {
			return "teacher-edit";
		}

		service.save(teacher);
		return "redirect:/teachers";
	}

	@ModelAttribute("teacher")
	Teacher getTeacher(@RequestParam Optional<Integer> id) {
		return id.flatMap(a -> service.getTeacherById(a)).orElse(new Teacher());
	}
}
