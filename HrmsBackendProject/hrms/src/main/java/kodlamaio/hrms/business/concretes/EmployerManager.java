package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.core.utilities.adapters.ValidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployerDao;
import kodlamaio.hrms.entities1.concretes.Employer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
//@RequiredArgsConstructor
public class EmployerManager implements EmployerService {

	private final EmployerDao employerDao;
	private final  ValidateService<Employer> validateService;

	

	public EmployerManager(EmployerDao employerDao, @Qualifier("EmployerValidate") ValidateService<Employer> validateService) {
		super();
		this.employerDao = employerDao;
		this.validateService = validateService;
	}

	
	

	
	@Override
	public DataResult<List<Employer>> getAll() {
		return new SuccessDataResult<List<Employer>>(this.employerDao.findAll(),"");
	}

	@Override
	public DataResult<Employer> get(int id) {
		return new SuccessDataResult<Employer>(this.employerDao.findById(id).get(),"");
	}

	@Override
	@Transactional
	@TransactionalEventListener
	public Result add(Employer employer) throws RemoteException {
		
		
		if (!this.validateService.validate(employer).isSuccess()) {
			return new ErrorResult(this.validateService.validate(employer).getMessage());
		}
		
		this.employerDao.save(employer);
		return new SuccessResult();
	}

	@Override
	public Result update(Employer employer) {
		this.employerDao.saveAndFlush(employer);
		return new SuccessResult();
	}

	@Override
	public Result delete(Employer employer) {
		this.employerDao.saveAndFlush(employer);
		return new SuccessResult();
	}

}
