package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.City;

public interface CityService {
	Result add(City city);

	DataResult<List<City>> getAll();

	DataResult<Optional<City>> get(int id);
}
