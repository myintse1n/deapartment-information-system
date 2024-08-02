package mm.edu.ec.mtu.model.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable {
	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q1")
	private BigDecimal question1Grade;
	
	@NotNull
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q2")
	private BigDecimal question2Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q3")
	private BigDecimal question3Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q4")
	private BigDecimal question4Grade;
	
	@NotNull
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q5")
	private BigDecimal question5Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q6")
	private BigDecimal question6Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q7")
	private BigDecimal question7Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q8")
	private BigDecimal question8Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q9")
	private BigDecimal question9Grade;
	
	@NotNull(message = "choost one")
	@Digits(integer = 3,fraction = 2)
	@Column(nullable = false,name = "Q10")
	private BigDecimal question10Grade;
	
	@NotNull(message = "choost one")
	@ManyToOne
	private Subject subject;
	
}
