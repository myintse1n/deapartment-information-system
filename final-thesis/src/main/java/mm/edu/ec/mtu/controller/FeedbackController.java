package mm.edu.ec.mtu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import mm.edu.ec.mtu.model.entity.Feedback;
import mm.edu.ec.mtu.model.entity.StudentYear;
import mm.edu.ec.mtu.model.service.FeedbackService;

@Controller
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @ModelAttribute("feedback")
    public Feedback feedback() {
        return new Feedback();
    }

    @GetMapping("/feedback")
    public String showFeedbackForm(
    		@RequestParam(required = false) Integer yearId,
    		ModelMap model
    		) {
        List<StudentYear> studentYears = feedbackService.getAllStudentYears();
        var teacherSubjects = feedbackService.findTeacherSubjectByYearId(yearId);
        model.put("studentYears", studentYears);
        model.put("teacherSubjects", teacherSubjects);
        System.out.println(teacherSubjects);
        return "feedback-form";
    }

    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute("feedback") Feedback feedback) {
    	
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback-success";
    }
}
