package kodlamaio.hrms.entities1.concretes;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.Nullable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper =false)
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_seeker_cv_experiences")

public class JobSeekerCVExperience {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	 @Column(name="job_seeker_cv_id")
	 private Integer jobSeekerCvId;
	 
	 @Column(name="job_title_id")
	 private Integer jobTitleId;
	 
	 @Column(name="city_id")
	 private int cityId;
	 
	 
	 @Column(name = "institution")
	 private String institution;
	 
	 @Column(name = "starting_date")
	 private Date startingDate;
	 
	 @Column(name = "ending_date")
	@Nullable
	 private Date endingDate;
	 
	 @Column(name="added_date_time")
	 private LocalDateTime addedDateTime;

	 //*********************************************
//	 @JsonIgnore
//	 @ManyToOne()
//	 @JoinColumn(name="city_id")
//	 private City city;
//	 
//	 @JsonIgnore
//	 @ManyToOne()
//	 @JoinColumn(name="job_seeker_cv_id")
//	 private JobSeekerCv jobSeekerCv;
////	 
//	 @JsonIgnore
//	 @ManyToOne()
//	 @JoinColumn(name="job_title_id")
//	 private JobTitle jobTitle;
//	 
		public JobSeekerCVExperience(Integer jobSeekerCvId, Integer jobTitleId,  Integer cityId,
				String institutionName, LocalDate startingDate, LocalDate endingDate) {
	
			
		}
	 
	 
	 
}
