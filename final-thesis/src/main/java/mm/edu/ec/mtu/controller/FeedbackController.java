package mm.edu.ec.mtu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("feedback")
public class FeedbackController {
	
	@GetMapping
	String feedback() {
		return "feedback";
	}
	
	@GetMapping("form")
	String feedbackEdit() {
		return "feedback-edit";
	}
	
	@PostMapping
	String save() {
		return "feedback";
	}

}
