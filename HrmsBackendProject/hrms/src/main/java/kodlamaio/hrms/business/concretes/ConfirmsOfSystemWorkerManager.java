package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ConfirmsOfSystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ConfirmsOfSystemWorkerDao;
import kodlamaio.hrms.entities1.concretes.ConfirmsOfSystemWorker;

@Service
public class ConfirmsOfSystemWorkerManager implements ConfirmsOfSystemWorkerService{

	@Autowired
	private ConfirmsOfSystemWorkerDao confirmsOfSystemWorkerDao;
	
	@Override
	public DataResult<List<ConfirmsOfSystemWorker>> getAll() {
		
		return new SuccessDataResult<List<ConfirmsOfSystemWorker>>(this.confirmsOfSystemWorkerDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<ConfirmsOfSystemWorker>> get(int id) {
		
		return new SuccessDataResult<Optional<ConfirmsOfSystemWorker>>(this.confirmsOfSystemWorkerDao.findById(id),"");
	}

	@Override
	public Result add(ConfirmsOfSystemWorker confirmsOfSystemWorker) {
		this.confirmsOfSystemWorkerDao.save(confirmsOfSystemWorker);
		return new SuccessResult();
	}

}
