
package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemWorkerConfirmsOfEmployerService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfEmployer;

@RequestMapping("/api/systemworkerconfirmsemployer/")
@RestController
@CrossOrigin
public class SystemWorkerConfirmsOfEmployersController {

	@Autowired
	private SystemWorkerConfirmsOfEmployerService systemWorkerConfirmsOfEmployerService;
	
	@GetMapping("getall")
	public DataResult<List<SystemWorkerConfirmsOfEmployer>> getAll(){
		return this.systemWorkerConfirmsOfEmployerService.getAll();
	}
	
	
}
