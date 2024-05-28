package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.Candidacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidacyRepository extends JpaRepository<Candidacy, Long> {
}
