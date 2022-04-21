package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobSeekerCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvEducationDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvEducation;
import kodlamaio.hrms.entities1.dtos.JobSeekerEducationAddDto;


@Service
public class JobSeekerCvEducationManager implements JobSeekerCvEducationService  {

	@Autowired
	private JobSeekerCvEducationDao jobSeekerCvEducationDao;
	@Override
	public Result add(JobSeekerCvEducation jobSeekerCvEducation) {
		this.jobSeekerCvEducationDao.saveAndFlush(jobSeekerCvEducation);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCvEducation jobSeekerCvEducation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCvEducation jobSeekerCvEducation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeekerCvEducation>> getAll() {
		return new SuccessDataResult<List<JobSeekerCvEducation>>(this.jobSeekerCvEducationDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<JobSeekerCvEducation>> get(int id) {
		// TODO Auto-generated method stub
		return new SuccessDataResult<Optional<JobSeekerCvEducation>>(this.jobSeekerCvEducationDao.findById(id),"");
	}

	@Override
	public Result add(JobSeekerEducationAddDto jobSeekerEducationAddDto) {
		JobSeekerCvEducation jobSeekerCvEducation=new JobSeekerCvEducation(
				jobSeekerEducationAddDto.getDegreeId(),
				jobSeekerEducationAddDto.getSchoolId(),
				jobSeekerEducationAddDto.getFacultyId(),
				jobSeekerEducationAddDto.getStudyFieldId(),
				jobSeekerEducationAddDto.getStartingDate(),
				jobSeekerEducationAddDto.getEndingDate(),
				jobSeekerEducationAddDto.getJobSeekerCVId()
				);
		this.jobSeekerCvEducationDao.save(jobSeekerCvEducation);
		return new SuccessResult();
	}

}
