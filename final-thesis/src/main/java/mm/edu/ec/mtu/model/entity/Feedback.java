package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false,name = "question1_grade")
	private int question1Grade;
	
	@Column(nullable = false,name = "question2_grade")
	private int question2Grade;
	
	@Column(nullable = false,name = "question3_grade")
	private int question3Grade;
	
	@Column(nullable = false,name = "question4_grade")
	private int question4Grade;
	
	@Column(nullable = false,name = "question5_grade")
	private int question5Grade;
	
	@Column(nullable = false,name = "question6_grade")
	private int question6Grade;
	
	@Column(nullable = false,name = "question7_grade")
	private int question7Grade;
	
	@Column(nullable = false,name = "question8_grade")
	private int question8Grade;
	
	@Column(nullable = false,name = "question9_grade")
	private int question9Grade;
	
	@Column(nullable = false,name = "question10_grade")
	private int question10Grade;
	
	@ManyToOne
	private Teacher teacher;
		
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Subject subject;
}
