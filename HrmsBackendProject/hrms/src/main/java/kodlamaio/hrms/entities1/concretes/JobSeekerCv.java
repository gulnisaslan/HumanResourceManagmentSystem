package kodlamaio.hrms.entities1.concretes;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@NoArgsConstructor
@AllArgsConstructor
@NonNull
@Table(name="job_seeker_cvs")

public class JobSeekerCv {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
    private Integer id;
    
//    @Column(name="job_seeker_id")
//    private int jobSeekerId;
 
	
//	@Column(name = "job_seeker_CV_image_id")
//	private int jobSeekerCVImageId;
 
	@Column(name="github_address")
    private String githubAddress;
    
    @Column(name="linkedin_address")
    private String linkedinAddress;
    
    @Column(name="cover_letter")
    private String coverLetter;


	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_date_time", updatable = false)
	private Date createdDateTime;

	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "last_updated_date_time", insertable = false)
	private Date lastUpdatedDateTime;
	
	@Column(name = "is_active")
	private boolean active = false;

	
	
	
	//------------------------------------------------------------------- 
	
	@ManyToOne
	@JoinColumn(name = "job_seeker_id")
	private JobSeeker jobSeeker;
	
	@ManyToOne
	@JoinColumn(name="job_seeker_CV_image_id")
	private JobSeekerCVImage jobSeekerCVImage;
    //********************************************************************
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerCvEducation> jobSeekerEducation;
	
//	@JsonIgnore
//	@OneToMany(mappedBy = "jobSeekerCv")
//	private List<JobSeekerCVExperience> jobSeekerCVExperiences;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCv")
	private List<JobSeekerCVImage> jobSeekerCVImages;
	
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekerCV")
	private List<JobSeekerCVLanguage> jobSeekerCVLanguages; 
	
	@JsonIgnore
	@OneToMany(mappedBy ="jobSeekerCv")
	private List<JobSeekerCvSkill> jobSeekerCvSkills;
	
	public JobSeekerCv(int jobSeekerId,String coverLatter,boolean active) {
		super();
		
		JobSeeker jobSeeker= new JobSeeker();
		this.jobSeeker.setId(jobSeekerId);
		
		this.coverLetter=coverLatter;
		
		this.active=active;
		
	}
	
	
}
