package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="student_year")
public class StudentYear implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "current_year" ,nullable = false, unique = true)
	private String currentYear;
	
	@OneToMany(mappedBy = "studentYear",cascade = CascadeType.ALL)
	private List<Student> students;
	
	@OneToMany(mappedBy = "year",cascade =CascadeType.ALL )
	private List<Subject> subjects;
}
