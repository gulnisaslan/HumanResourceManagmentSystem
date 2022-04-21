package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.abstracts.UserDao;
import kodlamaio.hrms.core.entities.User;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService{
	
	@Autowired
	private UserDao userDao;

	@Override
	public DataResult<List<User>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<User>>(this.userDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<User>> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<User>>(this.userDao.findById(id),"");
	}

	@Override
	public Result add(User user) {
		this.userDao.saveAndFlush(user);
		return new SuccessResult();
	}

	@Override
	public Result update(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(int UserId) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
