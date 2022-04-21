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

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.City;

@RequestMapping("api/cities/")
@RestController
@CrossOrigin
public class CitiesService {
	
	@Autowired
	private CityService cityService;
	
	@GetMapping("getall")
	public DataResult<List<City>> getall() {
		return this.cityService.getAll();
	}
	
	@GetMapping("get")
	public DataResult<Optional<City>> get(int id) {
		return this.cityService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody City city) {
		return this.cityService.add(city);
	}
	

}
