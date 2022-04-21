package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCv;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvAddDto;

public interface JobSeekerCvService {
	DataResult<List<JobSeekerCv>> getAll();

	DataResult<JobSeekerCv> get(int id);

	Result add(JobSeekerCv jobSeekerCv);

	Result update(JobSeekerCv jobSeekerCv);

	Result add(JobSeekerCvAddDto jobSeekerCvAddDto );
	
}
