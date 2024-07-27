package mm.edu.ec.mtu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mm.edu.ec.mtu.model.dto.TeacherSubjectByYear;
import mm.edu.ec.mtu.model.entity.Feedback;
import mm.edu.ec.mtu.model.entity.StudentYear;
import mm.edu.ec.mtu.model.entity.Subject;
import mm.edu.ec.mtu.model.entity.Teacher;
import mm.edu.ec.mtu.model.repo.FeedbackRepo;
import mm.edu.ec.mtu.model.repo.StudentYearRepo;
import mm.edu.ec.mtu.model.repo.SubjectRepo;
import mm.edu.ec.mtu.model.repo.TeacherRepo;

@Service
public class FeedbackService {

	@Autowired
	private FeedbackRepo feedbackRepository;

	@Autowired
	private StudentYearRepo studentYearRepository;

	@Autowired
	private TeacherRepo teacherRepository;

	@Autowired
	private SubjectRepo subjectRepository;
	
	public List<Teacher> getAllTeachers() {
	    return teacherRepository.findAll();
	}

	public List<Subject> getAllSubjects() {
	    return subjectRepository.findAll();
	}

	public List<StudentYear> getAllStudentYears() {
		return studentYearRepository.findAll();
	}

	
	public List<TeacherSubjectByYear> findTeacherSubjectByYearId(int yearId){
		return subjectRepository.findByYear(yearId);
	}
	
	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
}
