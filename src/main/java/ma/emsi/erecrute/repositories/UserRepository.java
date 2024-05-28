package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.Candidate;
import ma.emsi.erecrute.entites.Recruiter;
import ma.emsi.erecrute.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT c FROM Candidate c")
    List<Candidate> findAllCandidates();

    @Query("SELECT r FROM Recruiter r")
    List<Recruiter> findAllRecruiters();
}
