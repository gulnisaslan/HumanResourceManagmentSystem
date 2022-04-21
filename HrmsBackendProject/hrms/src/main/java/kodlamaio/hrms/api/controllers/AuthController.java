package kodlamaio.hrms.api.controllers;

import java.rmi.RemoteException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.AuthService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.Employer;
import kodlamaio.hrms.entities1.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth/")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@PostMapping("registerJobSeeker")
	public Result registerJobSeeker(@RequestBody JobSeeker jobSeeker) throws RemoteException {
		
		Result result = this.authService.registerJobSeeker(jobSeeker);
		
		if (result.isSuccess()) {
			return result;
		} 
		
		else {
			return result;
		}

	}
	
	@PostMapping("verifyJobSeeker")
	public Result verifyJobSeeker(String userACode, Integer jobSeekerId) {
		
		Result result = this.authService.verifyJobSeeker(userACode, jobSeekerId);
		
		if (result.isSuccess()) {
			return result;
		} 
		
		else {
			return result;
		}
	}
	
	@PostMapping("registerEmployer")
	public Result registerEmployer(@RequestBody Employer employer) throws RemoteException {
		
		Result result = this.authService.registerEmployer(employer);
		
		if (result.isSuccess()) {
			return result;
		} 
		
		else {
			return result;
		}

	}
	
	@PostMapping("verifyEmployer")
	public Result verifyEmployer(String userACode, Integer employerId) {
		
		Result result = this.authService.verifyEmployer(userACode, employerId);
		
		if (result.isSuccess()) {
			return result;
		} 
		
		else {
			return result;
		}
	}
	
	@PostMapping("systemworkerconfirmsofemployer")
	public Result systemPersonnelConfirmOfEmployer(int systemPersonnelId, int employerId) {
		Result result =this.authService.systemPersonnelConfirmOfEmployer(systemPersonnelId, employerId);
		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}
	
	
	@PostMapping("systemPersonnelConfirmOfJobAdvert")
	public Result systemPersonnelConfirmOfJobAdvert(int systemPersonnelId, int jobAdvertId) {
		Result result =this.authService.systemPersonnelConfirmOfJobAdvert(systemPersonnelId, jobAdvertId);
		if (result.isSuccess()) {
			return result;
		} else {
			return result;
		}
	}
}
