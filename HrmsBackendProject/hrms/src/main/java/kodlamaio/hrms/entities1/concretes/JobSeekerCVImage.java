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
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seeker_cv_images")

public class JobSeekerCVImage {
   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name= "id")
	private int id;
//	
//   @Column(name = "job_seeker_cv_id")
//    private int jobSeekerCVId;
//	
	@Column(name = "image_url")
	private String imageUrl;
	
	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "added_date_time", updatable = false)
	private Date addedDateTime;
	
	@UpdateTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_updated_date_time", insertable = false)
	private Date lastUpdatedDateTime;

    @ManyToOne()
    @JoinColumn(name="job_seeker_cv_id")
    private JobSeekerCv jobSeekerCv;
    
    @JsonIgnore
    @OneToMany(mappedBy="jobSeekerCVImage")
    private List<JobSeekerCv> jobSeekerCvs;
	

	
}