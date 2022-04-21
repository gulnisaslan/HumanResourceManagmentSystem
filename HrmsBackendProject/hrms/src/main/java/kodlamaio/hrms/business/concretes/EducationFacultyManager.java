package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationFacultyService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationFacultyDao;
import kodlamaio.hrms.entities1.concretes.EducationFaculty;

@Service
public class EducationFacultyManager implements EducationFacultyService{
	@Autowired
	private EducationFacultyDao educationFacultyDao;

	@Override
	public DataResult<List<EducationFaculty>> getAll() {
		return new SuccessDataResult<List<EducationFaculty>>(this.educationFacultyDao.findAll(),"");
	}

	@Override
	public Result add(EducationFaculty educationFaculty) {
		this.educationFacultyDao.saveAndFlush(educationFaculty);
		return new SuccessResult();
	}

	@Override
	public DataResult<Optional<EducationFaculty>> get(int id) {
	
		return new SuccessDataResult<Optional<EducationFaculty>>(this.educationFacultyDao.findById(id),"");
	}
}
