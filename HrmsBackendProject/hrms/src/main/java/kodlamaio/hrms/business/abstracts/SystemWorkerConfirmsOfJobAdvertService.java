package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfJobAdvert;

public interface SystemWorkerConfirmsOfJobAdvertService {

	DataResult<List<SystemWorkerConfirmsOfJobAdvert>> getAll();
	
	DataResult<SystemWorkerConfirmsOfJobAdvert> getById(int id);
	
	Result add(SystemWorkerConfirmsOfJobAdvert systemWorkerConfirmsOfJobAdvert);
	
	DataResult<SystemWorkerConfirmsOfJobAdvert> findByJobAdvertId(int jobAdvertId);

}
