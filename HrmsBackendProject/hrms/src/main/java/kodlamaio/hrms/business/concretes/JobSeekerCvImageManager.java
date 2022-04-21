package kodlamaio.hrms.business.concretes;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerCvImageService;
import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.cloudOperations.CloudService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobSeekerCvImageDao;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVImage;
import kodlamaio.hrms.entities1.concretes.JobSeekerCv;


@Service
public class JobSeekerCvImageManager implements JobSeekerCvImageService {

	
	@Autowired
	private JobSeekerCvImageDao jobSeekerCvImageDao;
	@Autowired
	private CloudService cloudService;
	@Autowired
	private JobSeekerCvService jobSeekerCvService;
	
	
	@Override
	public Result add(JobSeekerCVImage jobSeekerCVImage) {
		this.jobSeekerCvImageDao.saveAndFlush(jobSeekerCVImage);
		return new SuccessResult();
	}

	@Override
	public Result update(JobSeekerCVImage jobSeekerCVImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result delete(JobSeekerCVImage jobSeekerCVImage) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DataResult<List<JobSeekerCVImage>> getAll() {
		return new SuccessDataResult<List<JobSeekerCVImage>>(this.jobSeekerCvImageDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<JobSeekerCVImage>> getById(int id) {
		return new SuccessDataResult<Optional<JobSeekerCVImage>>(this.jobSeekerCvImageDao.findById(id),"");
	}

	@Override
	public Result saveImage(MultipartFile file, int jobSeekerCvId) {
	
		Map<String,String> uploader = (Map<String,String>)cloudService.save(file).getData();
		String imageUrl=uploader.get("url");
		JobSeekerCv jobSeekerCV= jobSeekerCvService.get(jobSeekerCvId).getData();
		
		if (jobSeekerCV.getJobSeekerCVImage()==null) {
			JobSeekerCVImage jobSeekerCVImage= new JobSeekerCVImage();
			jobSeekerCVImage.setImageUrl(imageUrl);
			jobSeekerCV.setJobSeekerCVImage(jobSeekerCVImage);
		} else {
			jobSeekerCV.getJobSeekerCVImage().setImageUrl(imageUrl);
		}
		jobSeekerCV.setLastUpdatedDateTime(new Date());
		jobSeekerCvService.add(jobSeekerCV);
		return new SuccessResult("Özgeçmişinize fotografınızı başarıyla eklediniz.");
	}


}
