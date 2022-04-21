package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerCvSkillService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvSkill;

@RequestMapping("/api/jobseekercvskill/")
@RestController
@CrossOrigin
public class JobSeekerCvSkillsController {

	@Autowired
	private JobSeekerCvSkillService jobsSeekerCvSkillService;
	
	@GetMapping("getall")
	public DataResult<List<JobSeekerCvSkill>> getAll(){
		return this.jobsSeekerCvSkillService.getAll();
	
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<JobSeekerCvSkill>> getById(int id){
	      return this.jobsSeekerCvSkillService.get(id);
	}
	
	@PostMapping("add")
	public Result add(JobSeekerCvSkill jobSeekerCvSkill) {
		return this.jobsSeekerCvSkillService.add(jobSeekerCvSkill);
		
	}
	
	
}
