package kodlamaio.hrms.entities1.dtos;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerCvExperienceAddDto {
	private Integer jobSeekerCvId;
	private Integer jobTitleId;
	private Integer cityId;
	private String institutionName;
	private LocalDate startingDate;
	private LocalDate endingDate;
	
}
