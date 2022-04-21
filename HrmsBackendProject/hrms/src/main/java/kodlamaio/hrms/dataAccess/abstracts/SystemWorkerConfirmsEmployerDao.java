package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfEmployer;

public interface SystemWorkerConfirmsEmployerDao extends JpaRepository<SystemWorkerConfirmsOfEmployer, Integer> {
     
	SystemWorkerConfirmsOfEmployer findByEmployerId(int employerId);
}
