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

import kodlamaio.hrms.business.abstracts.EducationFacultyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.EducationFaculty;

@RestController
@RequestMapping("api/educationfaculties/")
@CrossOrigin
public class EducationFacultiesController {

	@Autowired
	private EducationFacultyService educationFacultyService;
	
	@GetMapping("getall")
	public DataResult<List<EducationFaculty>> getAll(){
		
		return this.educationFacultyService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<Optional<EducationFaculty>> getById(int id){
		return this.educationFacultyService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody EducationFaculty educationFaculty) {
		return this.educationFacultyService.add(educationFaculty);
	}
}
