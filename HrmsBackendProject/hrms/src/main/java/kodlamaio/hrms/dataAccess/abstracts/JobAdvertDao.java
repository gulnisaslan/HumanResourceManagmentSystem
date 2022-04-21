package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlamaio.hrms.entities1.concretes.JobAdvert;
import kodlamaio.hrms.entities1.dtos.JobAdvertGetDto;

public interface JobAdvertDao extends JpaRepository<JobAdvert, Integer> {
      
	JobAdvert getByEmployerId(int employerId); 
	
	JobAdvert getByCityId(int cityId); 
	
	JobAdvert getByJobTitleId(int jobTitleId); 
	
	@Query("select new kodlamaio.hrms.entities1.dtos.JobAdvertGetDto"
			+ "(jA.id, e.companyName, jT.jobTitle, c.cityName, jA.jobDefinition, jA.numberOfOpenPositions," // çok dikkatsizsiniz
			+ " jA.deadlineForAppeal, jA.publishedDateTime) from Employer e"
			+ " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
			+ " inner join SystemWorkerConfirmsOfJobAdvert sWCOJA on sWCOJA.jobAdvertId=jA.id"
			+ " where jA.isActive=true and sWCOJA.didConfirm=true")
	List<JobAdvertGetDto> getConfirmedJobAdvertDtoByActiveTrue();

	@Query("select new kodlamaio.hrms.entities1.dtos.JobAdvertGetDto"
			+ "(jA.id, e.companyName, jT.jobTitle, c.cityName, jA.jobDefinition, jA.numberOfOpenPositions," 
			+ " jA.deadlineForAppeal, jA.publishedDateTime) from Employer e"
			+ " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
			+ " inner join SystemWorkerConfirmsOfJobAdvert sWCOJA on sWCOJA.jobAdvertId=jA.id"
			+ " where jA.isActive=true and sWCOJA.didConfirm=true and jA.id=:jobAdvertId")
	JobAdvertGetDto getConfirmedJobAdvertDtosByIdAndActiveTrue(int jobAdvertId);



	
	@Query("select new kodlamaio.hrms.entities1.dtos.JobAdvertGetDto"
			+ "(jA.id, e.companyName, jT.jobTitle, c.cityName, jA.jobDefinition, jA.numberOfOpenPositions," 
			+ " jA.deadlineForAppeal, jA.publishedDateTime) from Employer e"
			+ " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
			+ " inner join SystemWorkerConfirmsOfJobAdvert sWCOJA on sWCOJA.jobAdvertId=jA.id"
		    + " order by jA.publishedDateTime desc")
	List<JobAdvertGetDto> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();

	@Query("select new kodlamaio.hrms.entities1.dtos.JobAdvertGetDto"
			+ "(jA.id, e.companyName, jT.jobTitle, c.cityName, jA.jobDefinition, jA.numberOfOpenPositions,"
			+ " jA.deadlineForAppeal, jA.publishedDateTime) from Employer e"
			+ " inner join e.jobAdverts jA inner join jA.jobTitle jT inner join jA.city c"
			+ " inner join SystemWorkerConfirmsOfJobAdvert sWCOJA on sWCOJA.jobAdvertId=jA.id"
			+ " where jA.isActive=true and sWCOJA.didConfirm=true and e.id=:employerId")
	JobAdvertGetDto getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);

} 
