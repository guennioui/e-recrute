package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SkillRepository extends JpaRepository<Skill, Long> {
    Optional<Skill> findByName(String skillName);
}
