package kodlamaio.hrms.business.abstracts;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.Employer;


public interface EmployerService {
	DataResult<List<Employer>> getAll();

	DataResult<Employer> get(int id);

	Result add(Employer employer) throws RemoteException;

	Result update(Employer employer);

	Result delete(Employer employer);
}
