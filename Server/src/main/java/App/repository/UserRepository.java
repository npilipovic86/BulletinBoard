package App.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import App.model.SecurityUser;

@Repository
public interface UserRepository extends JpaRepository<SecurityUser, Long> {
	Optional<SecurityUser> findByUsername(String username);
}