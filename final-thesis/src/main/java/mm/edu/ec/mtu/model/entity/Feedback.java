package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	@Column(nullable = false,name = "question1_grade")
	private int question1Grade;
	
	@NotNull
	@Column(nullable = false,name = "question2_grade")
	private int question2Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question3_grade")
	private int question3Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question4_grade")
	private int question4Grade;
	
	@NotNull
	@Column(nullable = false,name = "question5_grade")
	private int question5Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question6_grade")
	private int question6Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question7_grade")
	private int question7Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question8_grade")
	private int question8Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question9_grade")
	private int question9Grade;
	
	@NotNull(message = "choost one")
	@Column(nullable = false,name = "question10_grade")
	private int question10Grade;
	
	@NotNull(message = "choost one")
	@ManyToOne
	private Subject subject;
	
}
