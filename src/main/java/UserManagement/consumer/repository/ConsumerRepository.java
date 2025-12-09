package UserManagement.consumer.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import UserManagement.consumer.model.Consumer;

public interface ConsumerRepository extends JpaRepository<Consumer, Long> {

  Optional<Consumer> findByEmail(String email);
}
