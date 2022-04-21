package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerDao;
import kodlamaio.hrms.entities1.concretes.SystemWorker;

@Service
public class SystemWorkerManager implements SystemWorkerService{
	
	@Autowired
	private SystemWorkerDao systemWorkerDao;

	@Override
	public DataResult<List<SystemWorker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SystemWorker>>(this.systemWorkerDao.findAll(),"");
	}

	@Override
	public DataResult<SystemWorker> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<SystemWorker>(this.systemWorkerDao.getOne(id),"");
	}

	@Override
	public Result add(SystemWorker systemWorker) {
		this.systemWorkerDao.saveAndFlush(systemWorker);
		return new SuccessResult();
	}

	@Override
	public Result update(SystemWorker systemWorker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(SystemWorker systemWorker) {
		// TODO Auto-generated method stub
		return null;
	}	
}
