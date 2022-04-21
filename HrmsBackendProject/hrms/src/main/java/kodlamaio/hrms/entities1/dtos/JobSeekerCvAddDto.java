package kodlamaio.hrms.entities1.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerCvAddDto {

	private int jobSeekerId;
	private String coverLatter;
	private Boolean active;
}
