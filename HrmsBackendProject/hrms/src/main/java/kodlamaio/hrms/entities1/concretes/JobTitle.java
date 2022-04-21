package kodlamaio.hrms.entities1.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name="job_titles")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobAdverts","jobSeekerCVExperiences"})
public class JobTitle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name="job_title",unique = true)
	private String jobTitle;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobTitle")
	private List<JobAdvert> jobAdverts;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "jobTitle")
//	private List<JobSeekerCVExperience> jobSeekerCVExperiences;
//	
	

}
