package kodlamaio.hrms.entities1.concretes;


import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.core.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name="job_seekers")
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer","handler","jobSeekerCvs"})
public class JobSeeker extends User {

	@NotBlank(message = "TC Kimlik alanı boş olamaz")
	@Size(min = 11,max = 11,message = "TC Kimlik  no 11 haneli olmalıdır")
	@Column(name = "national_id")
	private String nationalId;
	
	@NotBlank(message = "Doğum tarihi alanı boş bırakılmaz.")
	@Column(name="birth_date")
	private LocalDate birthDate;
	
	@NotBlank(message = "İsim alanı boş olamaz")
	@Column(name="first_name")
	private String firstName;
	
	@NotBlank(message = "Soyadı alanı boş bırakılmaz")
	@Column(name="last_name")
	private String lastName;
	

	@JsonIgnore
	@OneToMany(mappedBy ="jobSeeker")
	private List<JobSeekerCv> jobSeekerCvs;
}
