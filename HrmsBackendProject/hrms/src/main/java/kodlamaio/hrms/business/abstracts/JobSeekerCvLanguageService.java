package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVLanguage;

public interface JobSeekerCvLanguageService {
	DataResult<List<JobSeekerCVLanguage>> getAll();

	DataResult<Optional<JobSeekerCVLanguage>> getById(int id);

	Result add(JobSeekerCVLanguage jobSeekerCVLanguage);

	Result update(JobSeekerCVLanguage jobSeekerCVLanguage);

	Result delete(JobSeekerCVLanguage jobSeekerCVLanguage);
	
}
