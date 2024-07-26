package mm.edu.ec.mtu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import mm.edu.ec.mtu.model.entity.Feedback;
import mm.edu.ec.mtu.model.entity.StudentYear;
import mm.edu.ec.mtu.model.entity.Subject;
import mm.edu.ec.mtu.model.entity.Teacher;
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
    public String showFeedbackForm(Model model) {
        List<StudentYear> studentYears = feedbackService.getAllStudentYears();
        model.addAttribute("studentYears", studentYears);
        return "feedback-form";
    }

    @ResponseBody
    @GetMapping("/feedback/teachers-subjects")
    public Map<String, List<?>> getTeachersAndSubjects(@RequestParam("yearId") int yearId) {
        List<Teacher> teachers = feedbackService.getTeachersByYearId(yearId);
        List<Subject> subjects = feedbackService.getSubjectsByYearId(yearId);
        Map<String, List<?>> response = new HashMap<>();
        response.put("teachers", teachers);
        response.put("subjects", subjects);
        return response;
    }
  
    @PostMapping("/feedback")
    public String submitFeedback(@ModelAttribute("feedback") Feedback feedback) {
        feedbackService.saveFeedback(feedback);
        return "redirect:/feedback-success";
    }
}
