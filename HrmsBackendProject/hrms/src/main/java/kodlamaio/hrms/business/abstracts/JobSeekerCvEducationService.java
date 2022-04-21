package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvEducation;
import kodlamaio.hrms.entities1.dtos.JobSeekerEducationAddDto;
public interface JobSeekerCvEducationService {
	Result add(JobSeekerCvEducation jobSeekerCvEducation);

	Result update(JobSeekerCvEducation jobSeekerCvEducation);

	Result delete(JobSeekerCvEducation jobSeekerCvEducation);
	
	Result add(JobSeekerEducationAddDto jobSeekerEducationAddDto );

	DataResult<List<JobSeekerCvEducation>> getAll();
	
	DataResult<Optional<JobSeekerCvEducation>> get(int id);
	
	
	
	
}
