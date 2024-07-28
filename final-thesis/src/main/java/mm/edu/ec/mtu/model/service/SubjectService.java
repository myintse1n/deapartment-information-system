package mm.edu.ec.mtu.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mm.edu.ec.mtu.model.entity.Subject;
import mm.edu.ec.mtu.model.repo.SubjectRepo;

@Service
@Transactional(readOnly = true)
public class SubjectService {

	@Autowired
	private SubjectRepo subjectRepo;
	
	public Subject findById(int id) {
		return subjectRepo.findById(id).orElse(null);
	}
}
