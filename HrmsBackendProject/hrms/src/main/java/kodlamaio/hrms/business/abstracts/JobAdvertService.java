package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobAdvert;
import kodlamaio.hrms.entities1.dtos.JobAdvertAddDto;
import kodlamaio.hrms.entities1.dtos.JobAdvertGetDto;


public interface JobAdvertService {
	DataResult<List<JobAdvert>> getAll();

	DataResult<JobAdvert> get(int id);

	Result add(JobAdvert jobAdvert);

	Result add(JobAdvertAddDto jobAdvertAddDto);

	Result update(JobAdvert advert);

	DataResult<JobAdvert> getByEmployerId(int employerId);

	DataResult<JobAdvert> getByCityId(int cityId);

	DataResult<JobAdvert> getByJobTitleId(int jobTitleId);

	DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByActiveTrue();

	DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtosByIdAndActiveTrue(int jobAdvertId);

	DataResult<List<JobAdvertGetDto>> getConfirmedJobAdvertDtosByPublishedDateTimeAndActiveTrue();

	DataResult<JobAdvertGetDto> getConfirmedJobAdvertDtosByEmployerIdAndActiveTrue(int employerId);

	Result toggleJobAdvertActivePassive(int jobAdvertId, boolean isActived);

}

