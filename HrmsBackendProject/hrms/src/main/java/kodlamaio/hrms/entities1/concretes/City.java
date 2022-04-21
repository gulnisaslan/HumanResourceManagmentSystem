package kodlamaio.hrms.entities1.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="cities")
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper=false)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts","educationSchools"})
public class City {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotBlank
	@Column(name="city_name")
	private String cityName;
	
	
	//Map
	
	@OneToMany(mappedBy="city")	
	private List<JobAdvert> jobAdverts;
	
	@OneToMany(mappedBy="city")
	private List<EducationSchool> educationSchools;
	
//	@OneToMany(mappedBy = "city")
//	private List<JobSeekerCVExperience> jobSeekerCVExperiences; 
}
