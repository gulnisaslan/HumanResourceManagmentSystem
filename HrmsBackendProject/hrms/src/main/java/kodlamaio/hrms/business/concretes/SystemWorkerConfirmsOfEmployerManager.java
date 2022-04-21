package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerConfirmsEmployerDao;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfEmployer;

@Service
public class SystemWorkerConfirmsOfEmployerManager implements SystemWorkerConfirmsOfEmployerService {
	
	@Autowired
	private SystemWorkerConfirmsEmployerDao systemWorkerConfirmsOfEmployerDao;

	@Override
	public DataResult<List<SystemWorkerConfirmsOfEmployer>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<SystemWorkerConfirmsOfEmployer>>(this.systemWorkerConfirmsOfEmployerDao.findAll(),"");
	}

	@Override
	public DataResult<SystemWorkerConfirmsOfEmployer> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<SystemWorkerConfirmsOfEmployer>(this.systemWorkerConfirmsOfEmployerDao.getOne(id),"");
	}

	@Override
	public Result add(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer) {
		this.systemWorkerConfirmsOfEmployerDao.saveAndFlush(systemWorkerConfirmsOfEmployer);
		return new SuccessResult();
	}

	@Override
	public Result update(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(SystemWorkerConfirmsOfEmployer systemWorkerConfirmsOfEmployer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<SystemWorkerConfirmsOfEmployer> findByEmployerId(int employerId) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<SystemWorkerConfirmsOfEmployer>(this.systemWorkerConfirmsOfEmployerDao.findByEmployerId(employerId),"");
	}

}
