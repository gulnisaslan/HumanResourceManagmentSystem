package kodlamaio.hrms.business.abstracts;

import java.util.List;
import java.util.Optional;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities1.concretes.JobSeekerCvSkill;

public interface JobSeekerCvSkillService {
      DataResult<List<JobSeekerCvSkill>> getAll();
      
      DataResult<Optional<JobSeekerCvSkill>> get(int id);
      
      Result add(JobSeekerCvSkill jobSeekerCvSkill);
      
      Result update(JobSeekerCvSkill jobSeekerCvSkill);
      
      Result delete (JobSeekerCvSkill jobSeekerCvSkill);
}
