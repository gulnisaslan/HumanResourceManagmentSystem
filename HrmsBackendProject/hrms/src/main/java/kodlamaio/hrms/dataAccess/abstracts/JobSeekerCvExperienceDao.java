package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.JobSeekerCVExperience;


public interface JobSeekerCvExperienceDao extends JpaRepository<JobSeekerCVExperience, Integer>{

}