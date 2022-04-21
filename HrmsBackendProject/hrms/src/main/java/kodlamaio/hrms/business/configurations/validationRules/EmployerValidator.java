package kodlamaio.hrms.business.configurations.validationRules;

import java.rmi.RemoteException;

import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.adapters.ValidateService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.core.utilities.validates.RegexEmailChecker;
import kodlamaio.hrms.entities1.concretes.Employer;

@Component("EmployerValidate")
public class EmployerValidator implements ValidateService<Employer> {

	@Override
	public Result validate(Employer employer) throws RemoteException {
		
		if (!RegexEmailChecker.match(employer.getEmailAddress())) {
			return new ErrorResult("E-posta, e-posta formatında olmalıdır.");
		}
		
		
		String[] splitStringArr1 = employer.getEmailAddress().split("@");
		String[] splitStringArr2 = employer.getCompanyWebsite().split("\\.");

		// TODO: Buralar iş koduna çevrilecek
		
		if( !splitStringArr1[1].equals(splitStringArr2[1] + "." + splitStringArr2[2]) ) {
			return new ErrorResult("E-posta domain'i ile web sitesi domain'i aynı olmalıdır.");
		}

		
		System.out.println(splitStringArr1[0] + " " + splitStringArr1[1]);
		
		System.out.println(splitStringArr2[0] + " " + splitStringArr2[1] + " " + splitStringArr2[2]);		
		
		System.out.println(String.format("%s %s", splitStringArr1[0], splitStringArr1[1]));
		
		return new SuccessResult();
		
	}
	
	
	
}

