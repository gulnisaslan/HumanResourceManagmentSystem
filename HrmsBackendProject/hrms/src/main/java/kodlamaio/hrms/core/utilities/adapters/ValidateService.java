package kodlamaio.hrms.core.utilities.adapters;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.Result;

public interface ValidateService<T extends User> {
      Result validate(T t) throws RemoteException;
}
