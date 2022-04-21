package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.ActivationCodeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.ActivationCodeDao;
import kodlamaio.hrms.entities1.concretes.ActivationCode;

@Service
public class ActivationCodeManager implements ActivationCodeService  {
	
	@Autowired
	private ActivationCodeDao activationCodeDao;
	

	@Override
	public Result add(ActivationCode activationCode) {
		this.activationCodeDao.save(activationCode);		
		return new SuccessResult();
	}
	
	@Override
	public DataResult<List<ActivationCode>> getAll() {
		
		return new SuccessDataResult<List<ActivationCode>>(this.activationCodeDao.findAll(),"Activation Code Listed.");
	}

	@Override
	public DataResult<ActivationCode> get(int id) {
	
		return new SuccessDataResult<ActivationCode>(this.activationCodeDao.getOne(id),"");
	}

	@Override
	public DataResult<ActivationCode> getByUserId(Integer userId) {
		
		return new SuccessDataResult<ActivationCode>(this.activationCodeDao.getByUserId(userId),"");
	}

	

}
