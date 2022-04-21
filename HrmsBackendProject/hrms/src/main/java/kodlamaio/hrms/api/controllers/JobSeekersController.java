package kodlamaio.hrms.api.controllers;

import java.rmi.RemoteException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobSeekerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeeker;

@RequestMapping("/api/jobseekers/")
@RestController
@CrossOrigin
public class JobSeekersController {

	@Autowired
	private JobSeekerService jobSeekerService;
	
	@GetMapping("getall")
	public DataResult<List<JobSeeker>> getAll(){
		return this.jobSeekerService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobSeeker> getAll(int id){
		return this.jobSeekerService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobSeeker jobSeeker) throws RemoteException {
		return this.jobSeekerService.add(jobSeeker);
	}
	
}
