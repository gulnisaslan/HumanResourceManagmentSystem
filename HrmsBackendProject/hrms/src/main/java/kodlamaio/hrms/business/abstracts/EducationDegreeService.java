package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationDegree;


public interface EducationDegreeService {
	DataResult<List<EducationDegree>> getAll();

	DataResult<Optional<EducationDegree>> get(int id);

	Result add(EducationDegree educationDegree);
}
