package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVImage;

public interface JobSeekerCvImageService {
	Result add(JobSeekerCVImage jobSeekerCVImage);

	Result update(JobSeekerCVImage jobSeekerCVImage);

	Result delete(JobSeekerCVImage jobSeekerCVImage);

	DataResult<List<JobSeekerCVImage>> getAll();

	DataResult<Optional<JobSeekerCVImage>> getById(int id);
	
	Result saveImage(MultipartFile file, int jobSeekerCvId);
}
