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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="jobseeker_cv_languge")
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerCVLanguage {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
//	@Column(name = "job_seeker_cv_id")
//	private int jobSeekerCvId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "proficiency")
	private String proficiency;
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime;
	

	@ManyToOne
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekerCv jobSeekerCV;
}
