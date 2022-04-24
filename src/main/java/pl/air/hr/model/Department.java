package pl.air.hr.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "departments")
@NoArgsConstructor @Getter @Setter
public class Department {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dep_id")
	private Integer id;
	
	private String name;
	
	private String location;

}
