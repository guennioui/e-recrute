package ma.emsi.erecrute.repositories;

import ma.emsi.erecrute.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
