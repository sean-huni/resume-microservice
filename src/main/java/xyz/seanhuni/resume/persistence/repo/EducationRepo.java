package xyz.seanhuni.resume.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.seanhuni.resume.persistence.entity.Education;

@Repository
public interface EducationRepo extends JpaRepository<Education, Integer> {

}
