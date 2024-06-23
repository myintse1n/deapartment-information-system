package mm.edu.ec.mtu.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "admin")
public class Admin {
	@Id
	private String email;
	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	private Role role=Role.Admin;
	
	public enum Role{
		Admin,Student
	}
	
	public Admin() {
		if(this.role==null)
			this.role=Role.Admin;
	}
}
