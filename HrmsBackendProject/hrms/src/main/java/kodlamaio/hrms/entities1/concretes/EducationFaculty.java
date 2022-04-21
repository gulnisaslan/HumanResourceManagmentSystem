package kodlamaio.hrms.entities1.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "education_faculties")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCvEducations"})
public class EducationFaculty {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "university_id")
	private int universityId;
	
	@NotNull
	@Column(name = "is_active")
	private boolean active;
	

	
	@JsonIgnore
	@OneToMany(mappedBy = "educationFaculty")
	private List<JobSeekerCvEducation> jobSeekerCvEducations;
}
