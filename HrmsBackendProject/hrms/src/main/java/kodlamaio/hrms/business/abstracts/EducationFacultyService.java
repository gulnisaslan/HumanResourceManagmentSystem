package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationFaculty;

public interface EducationFacultyService {
	DataResult<List<EducationFaculty>> getAll();

	DataResult<Optional<EducationFaculty>> get(int id);

	Result add(EducationFaculty educationFaculty);
}
