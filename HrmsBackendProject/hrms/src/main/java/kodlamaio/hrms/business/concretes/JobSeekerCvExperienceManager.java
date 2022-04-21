package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvExperienceDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVExperience;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvExperienceAddDto;

@Service
public class JobSeekerCvExperienceManager implements  JobSeekerCvExperienceService {

	@Autowired
	private  JobSeekerCvExperienceDao jobSeekerCvExperienceDao;
	
	@Override
	public Result add(JobSeekerCVExperience jobSeekerCvExperience) {
		this.jobSeekerCvExperienceDao.saveAndFlush(jobSeekerCvExperience);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVExperience jobSeekerCvExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVExperience jobSeekerCvExperience) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeekerCVExperience>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVExperience>>(this.jobSeekerCvExperienceDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<JobSeekerCVExperience>> getById(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<JobSeekerCVExperience>>(this.jobSeekerCvExperienceDao.findById(id),"");
	}

	@Override
	public Result add(JobSeekerCvExperienceAddDto jobSeekerCvExperienceAddDto) {
		JobSeekerCVExperience jobSeekerCVExperience= new JobSeekerCVExperience(
				jobSeekerCvExperienceAddDto.getJobSeekerCvId(),
				jobSeekerCvExperienceAddDto.getJobTitleId(),
				jobSeekerCvExperienceAddDto.getCityId(),
				jobSeekerCvExperienceAddDto.getInstitutionName(),
				jobSeekerCvExperienceAddDto.getStartingDate(),
				jobSeekerCvExperienceAddDto.getEndingDate()
				);
		this.jobSeekerCvExperienceDao.saveAndFlush(jobSeekerCVExperience);
				
		return new SuccessResult();
	}

}
