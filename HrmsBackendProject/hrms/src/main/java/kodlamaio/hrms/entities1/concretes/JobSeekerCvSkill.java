 package kodlamaio.hrms.entities1.concretes;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "job_seeker_cv_skills")
@AllArgsConstructor
@NoArgsConstructor

public class JobSeekerCvSkill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@NotNull
	private int id;
	
	
//	@Column(name = "job_seeker_cv_id") 
//	private int jobSeekerCvId;
	 
	@NotNull
	@Column(name = "name")
	private String name;
	
	@NotNull
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="job_seeker_cv_id")
	private JobSeekerCv jobSeekerCv;
	
}
