package uz.malis.crudinspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.malis.crudinspringboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
