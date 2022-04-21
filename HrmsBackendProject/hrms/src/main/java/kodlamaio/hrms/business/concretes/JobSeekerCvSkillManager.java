package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvSkillDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvSkill;

@Service
public class JobSeekerCvSkillManager implements JobSeekerCvSkillService{
       
	@Autowired
	private JobSeekerCvSkillDao jobSeekerCvSkillDao;

	@Override
	public DataResult<List<JobSeekerCvSkill>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeekerCvSkill>>(this.jobSeekerCvSkillDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<JobSeekerCvSkill>> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<JobSeekerCvSkill>>(this.jobSeekerCvSkillDao.findById(id),"");
	}

	@Override
	public Result add(JobSeekerCvSkill jobSeekerCvSkill) {
		this.jobSeekerCvSkillDao.saveAndFlush(jobSeekerCvSkill);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCvSkill jobSeekerCvSkill) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCvSkill jobSeekerCvSkill) {
		// TODO Auto-generated method stub
		return null;
	}
}
