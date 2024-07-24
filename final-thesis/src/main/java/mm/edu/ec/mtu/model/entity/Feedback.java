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
	
	
	private String performace;
	
	@Column(nullable = false)
	private int grade;
	
	@ManyToOne
	private Student student;
	
	@ManyToOne
	private Subject subject;
}
