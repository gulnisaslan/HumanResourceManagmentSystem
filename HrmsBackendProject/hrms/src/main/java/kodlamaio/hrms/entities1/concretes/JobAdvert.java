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
import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@Table(name = "job_adverts")
@NoArgsConstructor
@AllArgsConstructor
public class JobAdvert {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

//	@Column(name="job_title_id")
//	private int jobTitleId;

//	@Column(name = "employer_id")
//	private Integer employerId;

//	@Column(name="city_id")
//	private int cityId;

	@NotNull
	@NotBlank
	@Column(name = "job_definition")
	private String jobDefinition;

	@Column(name = "min_salary")
	private double minSalary;

	@Column(name = "max_salary")
	private double maxSalary;

	@Column(name = "number_of_open_positions")
	private Integer numberOfOpenPositions;

	@Column(name = "deadline_for_appeal")
	private LocalDateTime deadlineForAppeal;

	@Column(name = "is_active")
	private boolean isActive = true;
	

	@Column(name = "published_date_time")
	private LocalDateTime publishedDateTime;

	// ----------------------------------------------

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "employer_id")
	private Employer employer;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;

	@NotBlank
	@ManyToOne
	@JoinColumn(name = "job_title_id")
	private JobTitle jobTitle;

	
	public JobAdvert(Integer cityId, Integer jobTitleId, Integer employerId,
			 String jobDefinition, double minSalary, double maxSalary,
			int numberOfOpenPositions, LocalDateTime deadlineForAppeal) {
		// JobAdvertAddDto Constructor
		
		super();
		
		this.jobDefinition = jobDefinition;
		
		this.minSalary = minSalary;
		this.maxSalary = maxSalary;
		
		this.numberOfOpenPositions = numberOfOpenPositions;
		this.deadlineForAppeal = deadlineForAppeal;
		
		this.city = new City();
		this.city.setId(cityId);
		
		this.jobTitle = new JobTitle();
		this.jobTitle.setId(jobTitleId);
		
		this.employer = new Employer();
		this.employer.setId(employerId);
		
		
	}
     
	
	// @Data anotasyonundan  ??t??r??(Lombok) getter ve setter'lar otomatik olu??turulur
	// isimleri de otomatik olarak verilir, bu otomatik verilen isimleri ilgili class'??n 
	// dosyas??na gidip sa?? taraftaki Outline sekmesinden kontrol edebilirsiniz
	// Outline sekmesini kaybederseniz, arama ??ubu??una gelip Outline yazman??z gerekir
	// veya ??st taraftaki a????l??r Window men??s??ndeki Show View se??ene??ine gelip
	// Outline'?? se??erek geri getirebilirsiniz ayr??ca Alt + Shift + Q klavye k??sayoluna
	// bast??ktan sonra O harfine basarak Outline sekmesini geri getirebilirsiniz
	
	// e??er otomatik olu??turulan getter ve setter'lar i??inizi g??rm??yorsa 
	// kendi custom getter ve setter'lar??n??z?? yazmal??s??n??z
	// kendi custom getter ve setter metotlar??n??z otomatik olu??turulan getter ve setter metotlar??n??n
	// ismi, d??n???? tipi ve parametreleri ayn?? olmal?? yoksa
	// hem otomatik olu??turulan hem de kendi yazd??????n??z getter - setter metotlar?? olu??ur
	// i??ler kar??????r, kendi custom getter - setter metotlar??n??z?? yazd??ktan sonra
	// muhakkak Outline sekmesine gelip otomatik olu??turulan(sol taraf??nda ye??il top olan)
	// getter - setter metotlar??n??n olmad??????n?? kontrol etmelisiniz
	
	// g??rd??????n??z gibi isActive field'?? i??in kendi custom getter ve setter'lar??m??z??(sol taraf??nda mavi
	// ????gen olan) yazd??ktan sonra otomatik olu??turulan ayn?? field i??in otomatik olu??turulan getter
	// ve setter'lar gitti. e??er otomatik olu??turulan getter ve setter'lar sizin i??in yeterli ise
	// kendi custom getter - setter'lar??n??z?? silip onlar?? geri getirebilirsiniz.





	
	
	

	
}

