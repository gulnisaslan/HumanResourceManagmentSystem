package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import kodlamaio.hrms.entities1.concretes.EducationDegree;

public interface EducationDegreeDao extends JpaRepository<EducationDegree, Integer> {

}
