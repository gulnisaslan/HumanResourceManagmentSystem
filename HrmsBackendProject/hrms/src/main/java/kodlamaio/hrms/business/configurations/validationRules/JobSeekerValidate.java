package kodlamaio.hrms.business.configurations.validationRules;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.adapters.ValidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validates.RegexEmailChecker;
import kodlamaio.hrms.entities1.concretes.JobSeeker;

@Component("JobSeekerValidate")
public class JobSeekerValidate implements ValidateService<JobSeeker> {

	@Override
	public Result validate(JobSeeker t) throws RemoteException {
	if (!RegexEmailChecker.match(t.getEmailAddress())) {
		return new ErrorResult("E-posta, e-posta formatında olmalıdır");
	}
		return new SuccessResult();
	}

}
