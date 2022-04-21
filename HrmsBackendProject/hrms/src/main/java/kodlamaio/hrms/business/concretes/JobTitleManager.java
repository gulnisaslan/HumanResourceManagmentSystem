package kodlamaio.hrms.business.concretes;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobTitleDao;
import kodlamaio.hrms.entities1.concretes.JobTitle;

@Service
public class JobTitleManager implements JobTitleService{
	@Autowired
   private JobTitleDao jobTitleDao;

	@Override
	public DataResult<List<JobTitle>> getAll() {
		
		return new SuccessDataResult<List<JobTitle>>(this.jobTitleDao.findAll(),"Meslek isimleri listelendi.");
	}

	@Override
	public DataResult<Optional<JobTitle>> get(int id) {
		return new SuccessDataResult<Optional<JobTitle>>(this.jobTitleDao.findById(id),"");
	}

	@Override
	public Result add(JobTitle jobTitle) {
		this.jobTitleDao.saveAndFlush(jobTitle);
		return new SuccessResult();
	}

	@Override
	public Result delete(JobTitle jobTitle) {
		this.jobTitleDao.delete(jobTitle);
		return new SuccessResult();
	}

	@Override
	public Result update(JobTitle jobTitle) {
		this.jobTitleDao.save(jobTitle);
		return new SuccessResult();
	}

}
