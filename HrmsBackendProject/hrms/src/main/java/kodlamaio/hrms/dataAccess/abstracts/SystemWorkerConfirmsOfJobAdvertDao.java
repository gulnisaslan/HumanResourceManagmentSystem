package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.SystemWorkerConfirmsOfJobAdvert;

public interface SystemWorkerConfirmsOfJobAdvertDao extends JpaRepository<SystemWorkerConfirmsOfJobAdvert, Integer> {

	SystemWorkerConfirmsOfJobAdvert findByJobAdvertId(int jobAdvertId);
}
