package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCv;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvAddDto;


@Service
public class JobSeekerCvManager implements JobSeekerCvService{

	
	@Autowired 
	private JobSeekerCvDao jobSeekerCvDao;

	@Override
	public DataResult<List<JobSeekerCv>> getAll() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobSeekerCv>>(this.jobSeekerCvDao.findAll(),"");
	}

	@Override
	public DataResult<JobSeekerCv> get(int id) {
		return new SuccessDataResult<JobSeekerCv>(this.jobSeekerCvDao.getOne(id),"");
	}

	@Override
	public Result add(JobSeekerCv jobSeekerCv) {
		this.jobSeekerCvDao.saveAndFlush(jobSeekerCv);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCv jobSeekerCv) {
		this.jobSeekerCvDao.save(jobSeekerCv);
		return new SuccessResult();
	}

	@Override
	public Result add(JobSeekerCvAddDto jobSeekerCvAddDto) {
	   JobSeekerCv jobSeekerCv=new JobSeekerCv(
			   jobSeekerCvAddDto.getJobSeekerId(),
			   jobSeekerCvAddDto.getCoverLatter(),
			   jobSeekerCvAddDto.getActive()
			   );
	   this.jobSeekerCvDao.saveAndFlush(jobSeekerCv);
			   
		return new SuccessResult();
	}
	
}
