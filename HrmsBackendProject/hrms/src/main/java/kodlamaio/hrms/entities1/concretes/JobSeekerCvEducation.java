package kodlamaio.hrms.entities1.concretes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Admin
 *
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seeker_cv_educations")
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class JobSeekerCvEducation {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
//	
//	@NotNull
//	@Column(name = "job_seeker_cv_id")
//	private int jobSekeerCVId;
//	
//	@NotNull
//	@Column(name = "degree_id")
//	private int degreeId;
////	
//	@NotNull
//	@Column(name = "school_id")
//	private int schoolId;
//	@NotNull
//	@Column(name = "faculty_id")
//	private int facultyId;
////	@NotNull
////	@Column(name = "study_field_id")
//	private int studyFieldId;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "starting_date")
	private LocalDate startingDate;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Column(name = "ending_date")
	private LocalDate endingDate;
	
	@Column(name = "added_date_time")
	private LocalDateTime addedDateTime = LocalDateTime.now();

	@Column(name = "status")
	private String status;

	@PrePersist
    public void setStatus() {
		if(endingDate!=null) {
			this.status="Mezun";
		}
		if(endingDate==null) {
			this.status="Devam Ediyor";
		}
	}
	
	
	
	 
	@JsonIgnore
//	@JsonIgnoreProperties({"jobSeekerCVEducations", "githubAddress", "linkedInAddress",
//		"coverLetter", "createdDateTime", "lastUpdatedDateTime", "active", "jobSeekerCVSkills",
//		"jobSeekerCVLanguages", "jobSeekerCVExperiences", "jobSeekerCVImage"})
	@ManyToOne()
	@JoinColumn(name = "job_seeker_cv_id")
	private JobSeekerCv jobSeekerCv;

	@OneToOne()
	@JoinColumn(name = "degree_id")
	private EducationDegree educationDegree;
	
	@OneToOne()
	@JoinColumn(name = "school_id")
	private EducationSchool educationSchool;
	
	@OneToOne()
	@JoinColumn(name = "faculty_id")
	private EducationFaculty educationFaculty;
	
	@OneToOne()
	@JoinColumn(name = "study_field_id")
	private EducationStudyField educationStudyField;

	
	public JobSeekerCvEducation(int degreeId, int schoolId, int facultyId, 
			int studyFieldId, LocalDate startingDate, LocalDate endingDate,
			int jobSeekerCVId) {
		
		this.educationDegree = new EducationDegree();
		this.educationDegree.setId(degreeId);
		
		this.educationSchool = new EducationSchool();
		this.educationSchool.setId(schoolId);
		
		this.educationFaculty = new EducationFaculty();
		this.educationFaculty.setId(facultyId);
		
		this.educationStudyField = new EducationStudyField();
		this.educationStudyField.setId(studyFieldId);
		
	 //   this.jobSekeerCvId = jobSeekerCVId;
		
		this.jobSeekerCv = new JobSeekerCv();
		this.jobSeekerCv.setId(jobSeekerCVId);
		
		this.startingDate = startingDate;
		
		this.endingDate = endingDate;
		
	}
}
