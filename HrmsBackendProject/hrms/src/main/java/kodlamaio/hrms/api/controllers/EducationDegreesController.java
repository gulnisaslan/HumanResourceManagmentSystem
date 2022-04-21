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

import kodlamaio.hrms.business.abstracts.EducationDegreeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationDegree;

@RestController
@RequestMapping("/api/educationdegrees/")
@CrossOrigin
public class EducationDegreesController {
	
	@Autowired
	private EducationDegreeService educationDegreeService;
	
	@GetMapping("getall")
	public DataResult<List<EducationDegree>> getAll() {
		return this.educationDegreeService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<EducationDegree>> getById(int id){
		return this.educationDegreeService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody EducationDegree educationDegree) {
		return this.educationDegreeService.add(educationDegree);
	}

}
