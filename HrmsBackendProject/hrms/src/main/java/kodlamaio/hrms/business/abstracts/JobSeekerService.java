package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeeker;


public interface JobSeekerService {
      
	DataResult<List<JobSeeker>> getAll();

	DataResult<JobSeeker> get(int id);

	Result add(JobSeeker jobSeeker) throws RemoteException;

	Result update(JobSeeker jobSeeker);

	Result delete(JobSeeker jobSeeker);
}
