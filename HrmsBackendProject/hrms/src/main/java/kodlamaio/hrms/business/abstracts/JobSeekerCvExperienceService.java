package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVExperience;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvExperienceAddDto;


public interface JobSeekerCvExperienceService {
	Result add(JobSeekerCVExperience jobSeekerCvExperience);

	Result update(JobSeekerCVExperience jobSeekerCvExperience);

	Result delete(JobSeekerCVExperience jobSeekerCvExperience);

	Result add(JobSeekerCvExperienceAddDto jobSeekerCvExperienceAddDto);
	DataResult<List<JobSeekerCVExperience>> getAll();

	DataResult<Optional<JobSeekerCVExperience>> getById(int id);
}
