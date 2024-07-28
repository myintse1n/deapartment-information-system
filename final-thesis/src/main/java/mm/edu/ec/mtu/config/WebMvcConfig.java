package mm.edu.ec.mtu.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import mm.edu.ec.mtu.controller.converter.SubjectConverter;

@EnableWebMvc
@Configuration
@ComponentScan("mm.edu.ec.mtu")
public class WebMvcConfig implements WebMvcConfigurer{

	@Autowired
	private  SubjectConverter subjectConverter;

	
	@Bean
	SpringResourceTemplateResolver templateResolver() {
		var resolver = new SpringResourceTemplateResolver();
		resolver.setPrefix("/views/");
		resolver.setSuffix(".html");
		resolver.setCacheable(false);
		return resolver;
	}
	
	@Bean
	SpringTemplateEngine engine(SpringResourceTemplateResolver resolver) {
		var engine = new SpringTemplateEngine();
		engine.setTemplateResolver(resolver);
		return engine;
	}
	
	@Bean
	ThymeleafViewResolver viewResolver(SpringTemplateEngine engine) {
		var viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(engine);
		viewResolver.setContentType("text/html");
		return viewResolver;
	}
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/login").setViewName("login");
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addConverter(subjectConverter);
	}
}
