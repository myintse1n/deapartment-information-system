package mm.edu.ec.mtu.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import mm.edu.ec.mtu.model.entity.Subject;
import mm.edu.ec.mtu.model.service.SubjectService;

@Component
public class SubjectConverter implements Converter<String, Subject>{
	
	@Autowired
	private SubjectService subjectService;

	@Override
	public Subject convert(String id) {
		return subjectService.findById(Integer.parseInt(id));
	}

}
