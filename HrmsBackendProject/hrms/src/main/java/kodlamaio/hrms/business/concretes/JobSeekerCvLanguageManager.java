package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCVLanguageDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVLanguage;


@Service 
public class JobSeekerCvLanguageManager implements  JobSeekerCvLanguageService {

	@Autowired
	private JobSeekerCVLanguageDao jobSeekerCvLanguageDao; 
	
	@Override
	public DataResult<List<JobSeekerCVLanguage>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeekerCVLanguage>>(this.jobSeekerCvLanguageDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<JobSeekerCVLanguage>> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<JobSeekerCVLanguage>>(this.jobSeekerCvLanguageDao.findById(id),"");
	}

	@Override
	public Result add(JobSeekerCVLanguage jobSeekerCVLanguage) {
		this.jobSeekerCvLanguageDao.saveAndFlush(jobSeekerCVLanguage);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVLanguage jobSeekerCVLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVLanguage jobSeekerCVLanguage) {
		// TODO Auto-generated method stub
		return null;
	}

}
