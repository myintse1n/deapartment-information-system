package mm.edu.ec.mtu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

	public List<StudentYear> getAllStudentYears() {
		return studentYearRepository.findAll();
	}

	public List<Teacher> getTeachersByYearId(int yearId) {
		return teacherRepository.findByYearId(yearId);
	}

	public List<Subject> getSubjectsByYearId(int yearId) {
		return subjectRepository.findByYearId(yearId);
	}

	public void saveFeedback(Feedback feedback) {
		feedbackRepository.save(feedback);
	}
}
