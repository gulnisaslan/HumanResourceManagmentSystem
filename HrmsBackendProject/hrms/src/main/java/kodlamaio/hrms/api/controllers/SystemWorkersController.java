
package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemWorkerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.SystemWorker;

@RequestMapping("/api/systemworker/")
@RestController
@CrossOrigin
public class SystemWorkersController {

	@Autowired
	private SystemWorkerService systemWorkerService;
	
	@GetMapping("getall")
	public DataResult<List<SystemWorker>> getAll(){
		return this.systemWorkerService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<SystemWorker> getById(int id){
		return this.systemWorkerService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody SystemWorker systemWorker) {
		return this.systemWorkerService.add(systemWorker);
	}
}
