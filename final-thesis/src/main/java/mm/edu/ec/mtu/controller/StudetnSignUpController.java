package mm.edu.ec.mtu.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.SecurityContextRepository;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mm.edu.ec.mtu.model.service.StudentService;
import mm.edu.ec.mtu.model.service.dto.StudentSignUpForm;

@Controller
@RequestMapping("signup")
public class StudetnSignUpController {
	
	@Autowired
	private StudentService service;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private SecurityContextRepository securityContextRepository;
	
	private RequestCache reqCache = new HttpSessionRequestCache();
	
	
	@GetMapping
	String createAccount() {
		return "signup";
	}
	
	@PostMapping
	String signup(@ModelAttribute("form") @Validated  StudentSignUpForm form,
			BindingResult result, HttpServletRequest request,HttpServletResponse response) {
		
		if(result.hasErrors()) {
			return "signup";
		}
		
		//create student;
		service.create(form);
		
		//Authenticate
		var authentication= authenticationManager.authenticate(form.authentication());
		
		//Set Authentication Result to Security Context
		var securityContext = SecurityContextHolder.getContext();
		securityContext.setAuthentication(authentication);
		
		//Save Security Context to Security Context Repository
		securityContextRepository.saveContext(securityContext, request, response);
		
		//Redirect to Saved Request
		var redirectUrl = getSavedRequest(request, response)
				.map(SavedRequest::getRedirectUrl).orElse("/");
		
		return "redirect:%s".formatted(redirectUrl);
	}
	
	@ModelAttribute("form")
	StudentSignUpForm form() {
		return new StudentSignUpForm();
	}
	
	private Optional<SavedRequest> getSavedRequest(HttpServletRequest request, HttpServletResponse respone){
		return Optional.ofNullable(reqCache.getRequest(request, respone));
	}
}
