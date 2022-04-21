package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationStudyField;


public interface EducationStudyFieldService {
	DataResult<List<EducationStudyField>> getAll();

	DataResult<Optional<EducationStudyField>> get(int id);

	Result add(EducationStudyField educationStudyField);
}
