package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

public interface UserService {
	
	DataResult<List<User>> getAll();
	
	DataResult<Optional<User>> get(int id);
	
	Result add(User user);
	
	Result update(User user);
	
	Result delete(int UserId);
	
	
}
