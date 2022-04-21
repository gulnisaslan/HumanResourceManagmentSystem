package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationDegreeService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationDegreeDao;
import kodlamaio.hrms.entities1.concretes.EducationDegree;

@Service
public class EducationDegreeManager implements EducationDegreeService {

	@Autowired
	private EducationDegreeDao educationDegreeDao;
	
	@Override
	public DataResult<List<EducationDegree>> getAll() {
		return new SuccessDataResult<List<EducationDegree>>(this.educationDegreeDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<EducationDegree>> get(int id) {
		return new SuccessDataResult<Optional<EducationDegree>>(this.educationDegreeDao.findById(id),"");
	}

	@Override
	public Result add(EducationDegree educationDegree) {
		this.educationDegreeDao.saveAndFlush(educationDegree);
		return new SuccessResult();
	}

}
