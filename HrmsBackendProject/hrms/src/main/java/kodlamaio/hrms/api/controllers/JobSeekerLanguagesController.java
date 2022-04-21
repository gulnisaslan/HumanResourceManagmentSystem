package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvLanguageService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCVLanguage;


@RequestMapping("/api/jobseekercvlanguages/")
@RestController
@CrossOrigin
public class JobSeekerLanguagesController {

	@Autowired
	private JobSeekerCvLanguageService  jobSeekerCvService;
	
	
	@GetMapping("getall")
	public DataResult<List<JobSeekerCVLanguage>> getAll(){
		return this.jobSeekerCvService.getAll();
		}
	
	@GetMapping("getbyid")
	public DataResult<Optional<JobSeekerCVLanguage>> getById(int id){
		return this.jobSeekerCvService.getById(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobSeekerCVLanguage jobSeekerCVLanguage) {
		return this.jobSeekerCvService.add(jobSeekerCVLanguage);
	}
	
}
