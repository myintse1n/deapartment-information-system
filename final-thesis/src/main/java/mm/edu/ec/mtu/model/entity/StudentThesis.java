package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "student_thesis")
public class StudentThesis implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int studentId;
	@Column(nullable = false,name = "roll_no")
	private int rollNo;
    private String name;
    @Column(name = "thesis_title")
    private String thesisTitle;

    @ManyToOne
    @JoinColumn(name = "academic_year_id")
    private AcademicYear academicYear;

}
