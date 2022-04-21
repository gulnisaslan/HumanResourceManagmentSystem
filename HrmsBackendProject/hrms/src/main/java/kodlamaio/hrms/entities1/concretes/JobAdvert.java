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
     
	
	// @Data anotasyonundan  ötürü(Lombok) getter ve setter'lar otomatik oluşturulur
	// isimleri de otomatik olarak verilir, bu otomatik verilen isimleri ilgili class'ın 
	// dosyasına gidip sağ taraftaki Outline sekmesinden kontrol edebilirsiniz
	// Outline sekmesini kaybederseniz, arama çubuğuna gelip Outline yazmanız gerekir
	// veya üst taraftaki açılır Window menüsündeki Show View seçeneğine gelip
	// Outline'ı seçerek geri getirebilirsiniz ayrıca Alt + Shift + Q klavye kısayoluna
	// bastıktan sonra O harfine basarak Outline sekmesini geri getirebilirsiniz
	
	// eğer otomatik oluşturulan getter ve setter'lar işinizi görmüyorsa 
	// kendi custom getter ve setter'larınızı yazmalısınız
	// kendi custom getter ve setter metotlarınız otomatik oluşturulan getter ve setter metotlarının
	// ismi, dönüş tipi ve parametreleri aynı olmalı yoksa
	// hem otomatik oluşturulan hem de kendi yazdığınız getter - setter metotları oluşur
	// işler karışır, kendi custom getter - setter metotlarınızı yazdıktan sonra
	// muhakkak Outline sekmesine gelip otomatik oluşturulan(sol tarafında yeşil top olan)
	// getter - setter metotlarının olmadığını kontrol etmelisiniz
	
	// gördüğünüz gibi isActive field'ı için kendi custom getter ve setter'larımızı(sol tarafında mavi
	// üçgen olan) yazdıktan sonra otomatik oluşturulan aynı field için otomatik oluşturulan getter
	// ve setter'lar gitti. eğer otomatik oluşturulan getter ve setter'lar sizin için yeterli ise
	// kendi custom getter - setter'larınızı silip onları geri getirebilirsiniz.





	
	
	

	
}

