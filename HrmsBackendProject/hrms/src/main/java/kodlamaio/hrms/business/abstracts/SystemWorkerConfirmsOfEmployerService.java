package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfEmployer;

public interface SystemWorkerConfirmsOfEmployerService {
	DataResult<List<SystemWorkerConfirmsOfEmployer>> getAll();

	DataResult<SystemWorkerConfirmsOfEmployer> get(int id);

	Result add(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer);

	Result update(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer);

	Result delete(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer);
	
	DataResult<SystemWorkerConfirmsOfEmployer> findByEmployerId(int employerId);
}
