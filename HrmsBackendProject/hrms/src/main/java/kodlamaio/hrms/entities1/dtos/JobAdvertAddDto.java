package kodlamaio.hrms.entities1.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertAddDto {

	
	private Integer jobTitleId;

	private Integer employerId;

	private Integer cityId;

	private String jobDefinition;

	private double minSalary;

	private double maxSalary;

	private Integer numberOfOpenPositions;

	private LocalDateTime deadlineForAppeal;


}
