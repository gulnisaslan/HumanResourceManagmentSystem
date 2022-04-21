package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationSchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationSchoolDao;
import kodlamaio.hrms.entities1.concretes.EducationSchool;

@Service
public class EducationSchoolManager implements EducationSchoolService{
	
	@Autowired
	private EducationSchoolDao educationSchoolDao;

	@Override
	public DataResult<List<EducationSchool>> getAll() {
		
		return new SuccessDataResult<List<EducationSchool>>(this.educationSchoolDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<EducationSchool>> get(int id) {
		return new SuccessDataResult<Optional<EducationSchool>>(this.educationSchoolDao.findById(id),"");
	}

	@Override
	public Result add(EducationSchool educationSchool) {
		this.educationSchoolDao.saveAndFlush(educationSchool);
		return new SuccessResult();
	}

}
