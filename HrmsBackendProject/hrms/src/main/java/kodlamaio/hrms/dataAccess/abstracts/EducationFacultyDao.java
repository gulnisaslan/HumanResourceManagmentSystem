package kodlamaio.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities1.concretes.EducationFaculty;

public interface EducationFacultyDao extends JpaRepository<EducationFaculty,Integer> {

}
