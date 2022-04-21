package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.Employer;
import kodlamaio.hrms.entities1.concretes.JobSeeker;

public interface AuthService {
      
	Result registerJobSeeker(JobSeeker jobSeeker) throws RemoteException;
	
	Result verifyJobSeeker(String userVCode, int jobSeekerId); 
     
	Result registerEmployer(Employer employer) throws RemoteException;
	
	Result verifyEmployer(String userVCode, int employerId);
      
	Result login(String email, String password);
	 
	Result systemPersonnelConfirmOfEmployer(int systemPersonnelId, int employerId);
		
	Result systemPersonnelConfirmOfJobAdvert(int systemPersonnelId, int jobAdvertId);
     
      
      
      
}
