package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.JobAdvertService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobAdvert;
import kodlamaio.hrms.entities1.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities1.dtos.JobAdvertGetDto;

@RequestMapping("/api/jobadverts/")
@RestController
@CrossOrigin
public class JobAdvertsController {

	@Autowired
	private JobAdvertService jobAdvertService;
	
	@GetMapping("getall")
	public DataResult<List<JobAdvert>> getAll(){
		return this.jobAdvertService.getAll();
	}
	
	@GetMapping("getbyid")
	public DataResult<JobAdvert> getById(int id){
		return this.jobAdvertService.get(id);
	}
	
	@PostMapping("add")
	public Result add(@Validated @RequestBody JobAdvert jobAdvert) {
		return this.jobAdvertService.add(jobAdvert);
	}
	
	
	//To Do:Doğrulanmış iş ilanları listeleyen metod
	
	@GetMapping("getConfirmedJobAdvertDtosByActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtosByActiveTrue() {
		DataResult<List<JobAdvertGetDto>> dataResult = this.jobAdvertService.getConfirmedJobAdvertDtosByActiveTrue();
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}
	}
	
	//To Do:Doğrulanmış iş ilanlarını id'ye göre  listeleyen metod	
	@GetMapping("getConfirmedJobAdvertDtoByIdAndActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtoByIdAndActiveTrue(int jobAdvertId) {
		DataResult<JobAdvertGetDto> dataResult = this.jobAdvertService
				.getConfirmedJobAdvertDtosByIdAndActiveTrue(jobAdvertId);
		if (dataResult.isSuccess()) {
			return ResponseEntity.ok(dataResult);
		} else {
			return ResponseEntity.badRequest().body(dataResult);
		}	
	}
	//To Do:Doğrulanmış iş ilanların yayın tarihine göre listeleyen metod
	@GetMapping(" getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue")
	public ResponseEntity<?> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue(){
		DataResult<List<JobAdvertGetDto>> dataResult= this.jobAdvertService.getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();
	
		 if (dataResult.isSuccess()) {
				return ResponseEntity.ok(dataResult);
			}else {
				return ResponseEntity.badRequest().body(dataResult);
			}
	}
	//To Do:Doğrulanmış iş ilanları  employerId'ye göre listeleyen metod
	@GetMapping("getConfirmedJobAdvertDtosByEmployerIdAndActiveTru")
	public  ResponseEntity<?> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId){
	DataResult<JobAdvertGetDto>	dataResult= this.jobAdvertService.getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(employerId);
		 if (dataResult.isSuccess()) {
				return ResponseEntity.ok(dataResult);
			}else {
				return ResponseEntity.badRequest().body(dataResult);
			}
	}
	
	//İş veren tarafından iş ilanın aktif pasif hale getire metod
	@PostMapping("toggleJobAdvertActivePassive")
	public ResponseEntity<?> toggleJobAdvertActivePassive(int jobAdvertId, boolean isActived) {
		Result result=this.jobAdvertService.toggleJobAdvertActivePassive(jobAdvertId, isActived);
		if (!result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	
	//İş ilanını ekleme
	@PostMapping("add1")
	public ResponseEntity<?> add1( JobAdvertAddDto jobAdvertAddDto){
		Result result= this.jobAdvertService.add(jobAdvertAddDto);
		if(!result.isSuccess()) {
			return ResponseEntity.ok(result);
		}
		else {
			return ResponseEntity.badRequest().body(result);
		}
	}
	

}

