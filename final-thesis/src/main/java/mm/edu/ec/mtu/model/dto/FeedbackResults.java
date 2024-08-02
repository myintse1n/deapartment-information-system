package mm.edu.ec.mtu.model.dto;

import java.math.BigDecimal;

public interface FeedbackResults {

	String getSubjectName();
	BigDecimal getAvgFeedback();
	int getCount();
}
