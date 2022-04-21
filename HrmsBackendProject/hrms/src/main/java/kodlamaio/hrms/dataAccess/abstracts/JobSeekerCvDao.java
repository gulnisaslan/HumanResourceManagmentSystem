package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.JobSeekerCv;

public interface JobSeekerCvDao extends JpaRepository<JobSeekerCv, Integer> {
     
	List<JobSeekerCv> getByJobSeekerId(int jobSeekerId);
}
