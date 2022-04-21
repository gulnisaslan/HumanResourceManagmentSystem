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
@Table(name = "education_study_fields")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCvEducations"})
public class EducationStudyField {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;
	
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "university_id")
	private int universityId;
	
	@NotNull
	@Column(name = "faculty_id")
	private int facultyId;
	
	@NotNull
	@Column(name = "is_active")
	private boolean active;
	
	@JsonIgnore
	@OneToMany(mappedBy = "educationStudyField")
	private List<JobSeekerCvEducation> jobSeekerCVEducations;

}