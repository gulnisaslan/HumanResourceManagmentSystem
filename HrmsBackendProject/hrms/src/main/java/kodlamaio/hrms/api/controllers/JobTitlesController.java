package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobTitleService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobTitle;

@RestController
@RequestMapping("api/jobtitles/")
@CrossOrigin
public class JobTitlesController {
	
	@Autowired
	private JobTitleService jobTitleService;

	@GetMapping( "getall")
	public DataResult<List<JobTitle>> getAll() {
		return this.jobTitleService.getAll();
	}

	@GetMapping( "getbyid")
	public DataResult<Optional<JobTitle>> getById(int id) {
		return this.jobTitleService.get(id);
	}

	@PostMapping( "add")
	public Result add(@Validated @RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

   @PostMapping(name = "update")
	public Result update(@Validated  @RequestBody JobTitle jobTitle) {
		return this.jobTitleService.add(jobTitle);
	}

	@DeleteMapping(name = "delete")
	public Result delete(JobTitle jobTitle) {
		return this.jobTitleService.delete(jobTitle);
	}
}
