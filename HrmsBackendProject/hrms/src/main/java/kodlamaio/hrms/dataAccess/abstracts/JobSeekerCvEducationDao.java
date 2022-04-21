package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.JobSeekerCvEducation;

public interface JobSeekerCvEducationDao extends JpaRepository<JobSeekerCvEducation, Integer> {

}
