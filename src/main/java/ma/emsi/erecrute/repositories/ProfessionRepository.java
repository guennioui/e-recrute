package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.Profession;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Long> {
}
