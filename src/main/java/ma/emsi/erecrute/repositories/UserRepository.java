package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    @Query("SELECT c FROM Candidate c")
    List<Candidate> findAllCandidates();

    @Query("SELECT r FROM Recruiter r")
    List<Recruiter> findAllRecruiters();
}
