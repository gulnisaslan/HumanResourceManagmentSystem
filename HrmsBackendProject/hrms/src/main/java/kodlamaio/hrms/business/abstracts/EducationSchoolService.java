package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationSchool;

public interface EducationSchoolService {
	DataResult<List<EducationSchool>> getAll();

	DataResult<Optional<EducationSchool>> get(int id);

	Result add(EducationSchool educationSchool);
}
