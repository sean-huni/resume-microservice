package xyz.seanhuni.resume.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.seanhuni.resume.persistence.entity.Experience;


@Repository
public interface ExperienceRepo extends JpaRepository<Experience, Integer> {

}
