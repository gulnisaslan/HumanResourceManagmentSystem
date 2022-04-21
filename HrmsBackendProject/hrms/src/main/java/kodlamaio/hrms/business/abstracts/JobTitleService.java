package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobTitle;

public interface JobTitleService {
	DataResult<List<JobTitle>> getAll();

	DataResult<Optional<JobTitle>> get(int id);

	Result add(JobTitle jobTitle);

	Result delete(JobTitle jobTitle);

	Result update(JobTitle jobTitle);
   }
