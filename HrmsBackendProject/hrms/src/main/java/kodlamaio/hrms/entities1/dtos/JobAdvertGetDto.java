package kodlamaio.hrms.entities1.dtos;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobAdvertGetDto {

	private Integer id;
	private String companyName;
	private String jobTitle;
	private String cityName;
	private String jobDefinition;
	private Integer numberOfOpenPositions;
	private LocalDateTime deadlineForAppeal;
	private LocalDateTime publishedDateTime;
	
	
	
}
