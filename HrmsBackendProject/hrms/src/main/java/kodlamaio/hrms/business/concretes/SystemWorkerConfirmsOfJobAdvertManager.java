package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.SystemWorkerConfirmsOfJobAdvertDao;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfJobAdvert;

@Service
public class SystemWorkerConfirmsOfJobAdvertManager implements SystemWorkerConfirmsOfJobAdvertService {

	@Autowired
	private SystemWorkerConfirmsOfJobAdvertDao systemWorkerConfirmsOfJobAdvertDao;
	
	@Override
	public DataResult<List<SystemWorkerConfirmsOfJobAdvert>> getAll() {
		return new SuccessDataResult<List<SystemWorkerConfirmsOfJobAdvert>>(this.systemWorkerConfirmsOfJobAdvertDao.findAll(),"");
	}

	@Override
	public DataResult<SystemWorkerConfirmsOfJobAdvert> getById(int id) {
		
		return new SuccessDataResult<SystemWorkerConfirmsOfJobAdvert>(this.systemWorkerConfirmsOfJobAdvertDao.getOne(id),"");
	}

	@Override
	public Result add(SystemWorkerConfirmsOfJobAdvert systemWorkerConfirmsOfJobAdvert) {
		this.systemWorkerConfirmsOfJobAdvertDao.saveAndFlush(systemWorkerConfirmsOfJobAdvert);
		return new SuccessResult();
	}

	@Override
	public DataResult<SystemWorkerConfirmsOfJobAdvert> findByJobAdvertId(int jobAdvertId) {
		return new SuccessDataResult<SystemWorkerConfirmsOfJobAdvert>(this.systemWorkerConfirmsOfJobAdvertDao.findByJobAdvertId(jobAdvertId),"");
				
	}

}
