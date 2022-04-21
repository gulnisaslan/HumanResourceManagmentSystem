package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.EducationSchool;

public interface EducationSchoolDao extends JpaRepository<EducationSchool, Integer> {

}
