package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "subject")
public class Subject implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false, unique = true)
	private String code;
	
	@ManyToMany
	private List<Student> students;
	
	@ManyToOne
	private Teacher teacher;
	
	@ManyToOne
	private StudentYear year;
	
	@OneToMany(mappedBy = "subject",cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;
}
