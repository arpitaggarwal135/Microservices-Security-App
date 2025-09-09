package in.ashokit.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Data;

@Data
@Entity
@Table(
	name = "CUST_TBL",
	uniqueConstraints = @UniqueConstraint(columnNames = "CUST_EMAIL")
)
public class Customer {
	@Id
	@Column(name = "CUST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "CUST_NAME")
	private String name;
	
	@Column(name = "CUST_EMAIL")
	private String email;
	
	@Column(name = "CUST_PWD")
	private String pwd;
	
	@Column(name = "CUST_PHN")
	private Long phn;
}
