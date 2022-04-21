package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvEducationService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvEducation;
import kodlamaio.hrms.entities1.dtos.JobSeekerEducationAddDto;

@RequestMapping("/api/jobseekercveducations/")
@RestController
@CrossOrigin
public class JobSeekerCvEducationsController {
	
	@Autowired
	private JobSeekerCvEducationService jobSeekerCvEducationService;
	
	@GetMapping("getall")
	public DataResult<List<JobSeekerCvEducation>> getAll(){
		return this.jobSeekerCvEducationService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<JobSeekerCvEducation>> getById(int id){
		return this.jobSeekerCvEducationService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobSeekerCvEducation jobSeekerCvEducation){
		return this.jobSeekerCvEducationService.add(jobSeekerCvEducation);
		
	}
	@PostMapping("add1")
	public ResponseEntity<?> add1(JobSeekerEducationAddDto jobSeekerEducationAddDto){
		Result result=this.jobSeekerCvEducationService.add(jobSeekerEducationAddDto);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
}
