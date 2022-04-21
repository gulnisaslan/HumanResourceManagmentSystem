package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmailService;
import kodlamaio.hrms.business.abstracts.EmployerService;
import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfJobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertDao;
import kodlamaio.hrms.entities1.concretes.Employer;
import kodlamaio.hrms.entities1.concretes.JobAdvert;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfJobAdvert;
import kodlamaio.hrms.entities1.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities1.dtos.JobAdvertGetDto;

@Service
public class JobAdvertManager implements JobAdvertService {

	@Autowired
	private JobAdvertDao jobAdvertDao;
	
	@Autowired
	private EmployerService employerService;
	
	@Autowired
	private EmailService emailService; 
	
	@Autowired
	private SystemWorkerConfirmsOfJobAdvertService systemWorkerConfirmsOfJobAdvertService;
	
	
	
	
	
	
	@Override
	public DataResult<List<JobAdvert>> getAll() {
		return new SuccessDataResult<List<JobAdvert>>(this.jobAdvertDao.findAll(),"");
	}

	@Override
	public DataResult<JobAdvert> get(int id) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getOne(id),"");
	}

	@Override
	public Result add(JobAdvert jobAdvert) {
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		return new SuccessResult();
	}

	@Override
	public Result update(JobAdvert advert) {
		// TODO Auto-generated method stub
		return new SuccessResult();
	}

	@Override
	public DataResult<JobAdvert> getByEmployerId(int employerId) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByEmployerId(employerId), "");
	}

	@Override
	public DataResult<JobAdvert> getByCityId(int cityId) {
		
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByCityId(cityId),"");
	}

	@Override
	public DataResult<JobAdvert> getByJobTitleId(int jobTitleId) {
		return new SuccessDataResult<JobAdvert>(this.jobAdvertDao.getByJobTitleId(jobTitleId),"");
	}

	@Override
	public DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByActiveTrue() {
		return new SuccessDataResult<List<JobAdvertGetDto>>(this.jobAdvertDao.getConfirmedJobAdvertDtoByActiveTrue(),"");
	}

	@Override
	public DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtosByIdAndActiveTrue(int jobAdvertId) {
		return new SuccessDataResult<JobAdvertGetDto>(this.jobAdvertDao.getConfirmedJobAdvertDtosByIdAndActiveTrue(jobAdvertId),"");
	}

	@Override
	public Result add(JobAdvertAddDto jobAdvertAddDto) {

		JobAdvert jobAdvert = new JobAdvert(
				jobAdvertAddDto.getCityId(),
				jobAdvertAddDto.getJobTitleId(),
				jobAdvertAddDto.getEmployerId(),
				jobAdvertAddDto.getJobDefinition(), 
				jobAdvertAddDto.getMinSalary(),
				jobAdvertAddDto.getMaxSalary(), 
				jobAdvertAddDto.getNumberOfOpenPositions(),
				jobAdvertAddDto.getDeadlineForAppeal());
		
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		SystemWorkerConfirmsOfJobAdvert systemWorkerConfirmsOfJobAdvert=new SystemWorkerConfirmsOfJobAdvert();
		systemWorkerConfirmsOfJobAdvert.setDidConfirm(false);
		systemWorkerConfirmsOfJobAdvert.setJobAdvertId(jobAdvert.getId());
		this.systemWorkerConfirmsOfJobAdvertService.add(systemWorkerConfirmsOfJobAdvert);
		
		
		Employer employer= this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		this.emailService.sendSimpleMessage(employer.getEmailAddress(),  "Job Advert Publishing Req Notice",
				"İş ilanınızın yayınlanması için önce sistem personelinin doğrulaması gerekmektedir."
				+ " İş ilanınız sistem personelinin doğrulamasına gönderilmiştir.");
		return new SuccessResult("");
	}

	@Override
	public DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue() {
		// TODO Auto-generated method stub
		return new SuccessDataResult<List<JobAdvertGetDto>>(this.jobAdvertDao.getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue(),"");
	}

	@Override
	public DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId) {
		
		return new SuccessDataResult<JobAdvertGetDto>(this.jobAdvertDao.getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(employerId),"");
	}

	@Override
	public Result toggleJobAdvertActivePassive(int jobAdvertId, boolean isActived) {

		JobAdvert jobAdvert = this.jobAdvertDao.getOne(jobAdvertId);
		if (isActived == jobAdvert.isActive()) {
			return new ErrorResult(
					"İş ilanı zaten " + (jobAdvert.isActive() == true ? "Aktif" : "Pasif") + "leştirdiniz.");
		}
		jobAdvert.setActive(isActived);
		this.jobAdvertDao.saveAndFlush(jobAdvert);
		Employer employer = this.employerService.get(jobAdvert.getEmployer().getId()).getData();
		this.emailService.sendSimpleMessage(employer.getEmailAddress(), "Job Advert Passive notice",
				jobAdvert.getId() + " numaralı " + jobAdvert.getJobTitle() + " ilanını "
						+ (isActived == true ? "aktif " : "pasif") + "leştirdiniz.");
		return new SuccessResult(employer.getCompanyName() + "İş ilanıno aktif-pasif olma durumun degiştirdi.");

	}
	

	
     

}
