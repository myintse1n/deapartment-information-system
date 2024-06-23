package mm.edu.ec.mtu.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {
	@Id
	private String email;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
}
