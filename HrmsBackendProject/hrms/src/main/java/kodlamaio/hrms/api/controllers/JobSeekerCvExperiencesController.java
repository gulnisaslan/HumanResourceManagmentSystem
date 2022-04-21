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

import kodlamaio.hrms.business.abstracts.JobSeekerCvExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVExperience;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvExperienceAddDto;

@RequestMapping("/api/jobseekercvexperiences/")
@RestController
@CrossOrigin
public class JobSeekerCvExperiencesController {

	@Autowired
	private JobSeekerCvExperienceService jobSeekerCvExperienceService;
	
	
	@GetMapping("getall")
	public DataResult<List<JobSeekerCVExperience>> getAll(){
		return this.jobSeekerCvExperienceService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<JobSeekerCVExperience>> getById(int id){
		return this.jobSeekerCvExperienceService.getById(id);
	}
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobSeekerCVExperience jobSeekerCVExperience) {
		return this.jobSeekerCvExperienceService.add(jobSeekerCVExperience);
	}
	@PostMapping("add1")
	public ResponseEntity<?> add(JobSeekerCvExperienceAddDto jobSeekerCvExperienceAddDto) {
		Result result=this.jobSeekerCvExperienceService.add(jobSeekerCvExperienceAddDto);
		
		if (result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	
}
