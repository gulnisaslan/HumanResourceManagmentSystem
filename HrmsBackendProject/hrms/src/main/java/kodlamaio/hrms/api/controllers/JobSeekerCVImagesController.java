package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import kodlamaio.hrms.business.abstracts.JobSeekerCvImageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVImage;

@RequestMapping("/api/jobseekerimages/")
@RestController
@CrossOrigin
public class JobSeekerCVImagesController {

	@Autowired
	private JobSeekerCvImageService jobSeekerCvImageService;

	@GetMapping("getall")
	public DataResult<List<JobSeekerCVImage>> getAll() {
		return this.jobSeekerCvImageService.getAll();
	}

	@GetMapping("getbyid")
	public DataResult<Optional<JobSeekerCVImage>> getById(int id) {
		return this.jobSeekerCvImageService.getById(id);

	}
	
//	@PostMapping("add")
//	public Result add(@Validated @RequestBody JobSeekerCVImage jobSeekerCVImage) {
//		return this.jobSeekerCvImageService.add(jobSeekerCVImage);
//	}
	@PostMapping("uploadimage")
	public ResponseEntity<?> add(@RequestBody MultipartFile multipartFile,Integer jobSeekerCVId ){
		Result result =this.jobSeekerCvImageService.saveImage(multipartFile, jobSeekerCVId);
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.badRequest().body(result);

		}
	}
	
    
}
