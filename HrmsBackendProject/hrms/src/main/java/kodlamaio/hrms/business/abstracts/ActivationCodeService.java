package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.ActivationCode;

public interface ActivationCodeService {

	Result add(ActivationCode activationCode);
	
	DataResult<List<ActivationCode>> getAll();

	DataResult<ActivationCode> get(int id);
	
	DataResult<ActivationCode> getByUserId(Integer userId);
	

}
