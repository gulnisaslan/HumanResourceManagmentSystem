package kodlamaio.hrms.core.utilities.adapters;

import java.rmi.RemoteException;
import java.util.Locale;

import kodlamaio.hrms.core.utilities.results.ErrorResult;
import org.springframework.stereotype.Component;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.entities1.concretes.JobSeeker;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoap;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Component("MernisValidate")
public class MernisAdapter implements ValidateService<JobSeeker>{
     

	@Override
	public Result validate(JobSeeker jobSeeker) throws RemoteException{
		
		KPSPublicSoap kpsPublic = new KPSPublicSoapProxy();

		boolean isValidated = kpsPublic.TCKimlikNoDogrula(Long.parseLong(jobSeeker.getNationalId()), 
		jobSeeker.getFirstName().toUpperCase(new Locale("tr", "TR")), 
		jobSeeker.getLastName().toUpperCase(new Locale("tr", "TR")), 
		jobSeeker.getBirthDate().getYear());
	
		System.out.println(isValidated);
		
		
		if(isValidated == true) {
			return new SuccessResult();
		}

		else {
			return new ErrorResult();
		}

		
		
	}
}
