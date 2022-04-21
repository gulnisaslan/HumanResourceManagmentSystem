 package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities1.concretes.EducationSchool;

@RestController
@RequestMapping("api/eductionschools/")
@CrossOrigin
public class EductionSchoolsController {
	
	@Autowired
	private EducationSchoolService educationSchoolService;
	
	@GetMapping("getall")
	public DataResult<List<EducationSchool>> getAll(){
		return this.educationSchoolService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<EducationSchool>> getById(int id){
		return this.educationSchoolService.get(id);
	}
	
	
	
	
	

}
