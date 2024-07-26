package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	
	@Column(nullable = false)
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	private String role;
	
	@ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
	private List<Subject> subject;
	
	@ManyToOne
	private StudentYear studentYear;
	
	@OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
	private List<Feedback> feedbacks;
}
