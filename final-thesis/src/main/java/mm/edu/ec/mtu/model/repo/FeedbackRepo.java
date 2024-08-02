package mm.edu.ec.mtu.model.repo;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import mm.edu.ec.mtu.model.dto.FeedbackResults;
import mm.edu.ec.mtu.model.entity.Feedback;

public interface FeedbackRepo extends JpaRepositoryImplementation<Feedback, Integer> {
	
	@Query(
			nativeQuery = true,
			value = """
					SELECT s.name as subjectName , ROUND((AVG(Q1) + AVG(Q2) + AVG(Q3) + AVG(Q4) + AVG(Q5) + AVG(Q6) + AVG(Q7) + AVG(Q8) + AVG(Q9) + AVG(Q10)) / 10, 2) 
					as avgFeedback,count(f.id) as count
					FROM  subject s 
					left join feedback f on s.id = f.subject_id 
					left join teacher t on t.id = s.teacher_id  WHERE  t.id = ?
					group by s.name;
					"""
			)
	List<FeedbackResults> getFeedbackResults(int id);
}
