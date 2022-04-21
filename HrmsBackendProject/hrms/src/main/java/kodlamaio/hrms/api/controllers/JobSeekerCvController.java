package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCv;
import kodlamaio.hrms.entities1.dtos.JobSeekerCvAddDto;

@RequestMapping("/api/jobseekercv/")
@RestController
@CrossOrigin
public class JobSeekerCvController {

	@Autowired
	private JobSeekerCvService jobCvService;
	
	@GetMapping("getall")
	public DataResult<List<JobSeekerCv>> getAll(){
		return this.jobCvService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobSeekerCv> getById(int id){
		return this.jobCvService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobSeekerCv jobSeekerCv) {
		return this.jobCvService.add(jobSeekerCv);
	}
	
	@PostMapping("add1")
	public ResponseEntity<?>  add1(JobSeekerCvAddDto jobSeekerCvAddDto) {
		Result result=this.jobCvService.add(jobSeekerCvAddDto);
		if(result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	@PostMapping("update")
    public Result update(JobSeekerCv jobSeekerCv) {
		return this.jobCvService.update(jobSeekerCv);
	}
}