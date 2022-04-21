package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.JobSeekerCVImage;

public interface JobSeekerCvImageDao extends JpaRepository<JobSeekerCVImage,Integer> {

}
