package mm.edu.ec.mtu.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import mm.edu.ec.mtu.model.entity.Feedback;
import mm.edu.ec.mtu.model.entity.StudentYear;
import mm.edu.ec.mtu.model.entity.Subject;
import mm.edu.ec.mtu.model.repo.FeedbackRepo;
import mm.edu.ec.mtu.model.repo.StudentYearRepo;
import mm.edu.ec.mtu.model.repo.SubjectRepo;

@Service
@Transactional(readOnly = true)
public class FeedbackService {


    @Autowired
    private FeedbackRepo feedbackRepository;

    @Autowired
    private StudentYearRepo studentYearRepository;
    
    @Autowired
    private SubjectRepo subjectRepository;
    

    public List<StudentYear> getAllStudentYears() {
        return studentYearRepository.findAllByOrderById();
    }

    public List<Subject> findSubjectsByTeacherIdAndYear(String teacher, Integer year) {
        return subjectRepository.findByTeacherIdAndYearId(teacher, year);
    }
    
    @Transactional
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
