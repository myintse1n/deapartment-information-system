package mm.edu.ec.mtu.controller;

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

import mm.edu.ec.mtu.model.entity.Feedback;
import mm.edu.ec.mtu.model.service.FeedbackService;

@Controller
@RequestMapping("feedback")
public class FeedbackController {

	@Autowired
	private FeedbackService feedbackService;

	@GetMapping
	String feedback(@RequestParam(required = false) String teacher, @RequestParam(required = false) Integer year,
			ModelMap model) {

		var subject = feedbackService.findSubjectsByTeacherIdAndYear(teacher, year);
		model.put("subject", subject);
		return "feedback";
	}

	@GetMapping("success")
	String feedbackSuccess() {
		return "feedback-success";
	}

	@PostMapping
	String saveFeedback(@ModelAttribute("feedback") @Validated Feedback feedback, BindingResult result,
			@RequestParam(required = false) String teacher, @RequestParam(required = false) Integer year,
			ModelMap model) {
		if (result.hasErrors()) {
			return "feedback";
		}
		feedbackService.saveFeedback(feedback);
		return "redirect:/feedback/success";
	}

	@ModelAttribute("feedback")
	Feedback getFeedback(ModelMap model) {
		var studentYears = feedbackService.getAllStudentYears();
		model.put("years", studentYears);
		return new Feedback();
	}
}
