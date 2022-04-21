package kodlamaio.hrms.business.concretes;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.business.abstracts.UserService;
import kodlamaio.hrms.core.abstracts.UserDao;
import kodlamaio.hrms.core.utilities.adapters.ValidateService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlamaio.hrms.entities1.concretes.JobSeeker;

@Service
public class JobSeekerManager implements JobSeekerService{
	
	private JobSeekerDao jobSeekerDao;

	private ValidateService<JobSeeker> mernisValidateService;
	
	private ValidateService<JobSeeker> jobSeekerValidate;
	
	private UserService userService;
	
	@Autowired
	public JobSeekerManager(JobSeekerDao jobSeekerDao, UserDao userDao,
			@Qualifier("JobSeekerValidate") ValidateService<JobSeeker> jobSeekerValidate,
			@Qualifier("MernisValidate") ValidateService<JobSeeker> mernisValidateService,
			UserService userService) {
		super();
	
		this.jobSeekerDao = jobSeekerDao;
		this.jobSeekerValidate = jobSeekerValidate;
		this.mernisValidateService = mernisValidateService;
		this.userService = userService;
	}

	
	
	@Override
	public DataResult<List<JobSeeker>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(),"");
	}

	@Override
	public DataResult<JobSeeker> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findById(id).get(),"");
	}

	@Override
	public Result add(JobSeeker jobSeeker) throws RemoteException {
		
		
		if (!this.jobSeekerValidate.validate(jobSeeker).isSuccess()) {
			return new ErrorResult();
		}
		
		else if (!this.mernisValidateService.validate(jobSeeker).isSuccess()) {
			return new ErrorResult("Bu sisteme kaydolmak için T.C. vatandaşı olmanız gerekiyor");
		}		
		
		else if (this.checkIfEmailExists(jobSeeker.getEmailAddress())) {
			return new ErrorResult("Bu mail adresine sahip kullanıcı zaten mevcut");
		}
		
		else if (this.checkIfNationalIdExists(jobSeeker)) {
			return new ErrorResult();
		}
		
		
		this.jobSeekerDao.saveAndFlush(jobSeeker);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeeker jobSeeker) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private boolean checkIfEmailExists(String emailAddress) {
		boolean isEmailAddressExists = this.userService.getAll().getData().stream()
			.filter(u->u.getEmailAddress().equals(emailAddress))
			.findFirst().isPresent();
		return isEmailAddressExists;
	
	}
	
	private boolean checkIfNationalIdExists(JobSeeker jobSeeker)
	{
		boolean isNationalIdExists=this.jobSeekerDao.findAll().stream()
				.filter(js->js.getNationalId().equals(jobSeeker.getNationalId()))
				.findFirst().isPresent();
		return isNationalIdExists;
		
		
	}
	
}
