package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.ConfirmsOfSystemWorker;

public interface ConfirmsOfSystemWorkerService {
	DataResult<List<ConfirmsOfSystemWorker>> getAll();

	DataResult<Optional<ConfirmsOfSystemWorker>> get(int id);

	Result add(ConfirmsOfSystemWorker confirmsOfSystemWorker);
		
}
