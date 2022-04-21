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

import kodlamaio.hrms.business.abstracts.ConfirmsOfSystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.ConfirmsOfSystemWorker;

@RequestMapping("/api/confirmsofsystemworkers/")
@RestController
@CrossOrigin
public class ConfirmsOfSystemWorkersController {
		
	@Autowired
	private ConfirmsOfSystemWorkerService confirmsOfSystemWorkerService;
	
	@GetMapping("getall")
	public DataResult<List<ConfirmsOfSystemWorker>> getall(){
		return this.confirmsOfSystemWorkerService.getAll();
		}
	
	@GetMapping("getbyid")
	public DataResult<Optional<ConfirmsOfSystemWorker>> getById(int id){
		return this.confirmsOfSystemWorkerService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody ConfirmsOfSystemWorker confirmsOfSystemWorker) {
		return this.confirmsOfSystemWorkerService.add(confirmsOfSystemWorker);
	}
	
}
