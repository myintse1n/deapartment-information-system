package mm.edu.ec.mtu.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "teacher")
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String image;
	
	@NotBlank(message = "{teacher.name.notBlank}")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message = "{teacher.position.notBlank}")
	@Column(nullable = false)
	private String position;
	
	@Column(nullable = false,unique = true)
	@Email(message = "{teacher.email.notValid}")
	@NotBlank(message = "{teacher.email.notBlank}")
	private String email;
	
	@NotNull(message = "{teacher.phone.notBlank}")
	@Column(nullable = false)
	private String phone;
	
	@NotBlank(message = "{teacher.education.notBlank}")
	@Column(nullable = false)
	private String education;

}
