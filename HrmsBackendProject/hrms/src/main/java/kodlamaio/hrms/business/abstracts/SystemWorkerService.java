package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.SystemWorker;

public interface SystemWorkerService {
	DataResult<List<SystemWorker>> getAll();

	DataResult<SystemWorker> get(int id);

	Result add(SystemWorker systemWorker);

	Result update(SystemWorker systemWorker);

	Result delete(SystemWorker systemWorker);
}
