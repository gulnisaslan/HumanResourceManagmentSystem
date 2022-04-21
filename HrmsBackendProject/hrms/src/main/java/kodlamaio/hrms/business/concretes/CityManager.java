package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.CityService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.CityDao;
import kodlamaio.hrms.entities1.concretes.City;

@Service
public class CityManager implements CityService{
	@Autowired
	private CityDao cityDao;

	@Override
	public Result add(City city) {
		this.cityDao.saveAndFlush(city);
		return new SuccessResult("City Added");
	}

	@Override
	public DataResult<List<City>> getAll() {
		return new SuccessDataResult<List<City>>(this.cityDao.findAll(),"Cities Listed");
	}

	@Override
	public DataResult<Optional<City>> get(int id) {
		
		return new SuccessDataResult<Optional<City>>(this.cityDao.findById(id),"");
	}
}
