package kodlamaio.hrms.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.EducationStudyFieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities1.concretes.EducationStudyField;


@RequestMapping("/api/educationstudyfields/")
@RestController
@CrossOrigin
public class EducationStudyFieldsController{
    @Autowired
	private EducationStudyFieldService educationStudyFieldService;
	
	@GetMapping("getall")
	public DataResult<List<EducationStudyField>> getAll(){
		return this.educationStudyFieldService.getAll();
	}
	
	@GetMapping("getbyId")
	public DataResult<Optional<EducationStudyField>> getById(int id){
		return this.educationStudyFieldService.get(id);
	}
	
	
}
