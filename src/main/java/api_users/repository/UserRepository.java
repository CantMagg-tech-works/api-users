package api_users.repository;

import api_users.model.UserModel;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, UUID> {

  boolean existsByUsername(String username);

  boolean existsByUserId(UUID uuid);
}
