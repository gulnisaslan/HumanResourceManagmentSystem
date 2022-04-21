package kodlamaio.hrms.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EducationStudyFieldService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccessResult;
import kodlamaio.hrms.dataAccess.abstracts.EducationStudyFieldDao;
import kodlamaio.hrms.entities1.concretes.EducationStudyField;

@Service
public class EducationStudyFieldManager implements EducationStudyFieldService {
	
	@Autowired
	private EducationStudyFieldDao educationStudyFieldDao;

	@Override
	public DataResult<List<EducationStudyField>> getAll() {
		return new SuccessDataResult<List<EducationStudyField>>(this.educationStudyFieldDao.findAll(),"");
	}

	@Override
	public DataResult<Optional<EducationStudyField>> get(int id) {
		return new SuccessDataResult<Optional<EducationStudyField>>(this.educationStudyFieldDao.findById(id),"");
	}

	@Override
	public Result add(EducationStudyField educationStudyField) {
		this.educationStudyFieldDao.saveAndFlush(educationStudyField);
		return new SuccessResult();
	}


}
