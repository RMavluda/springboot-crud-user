package uz.malis.crudinspringboot.repository;

//import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import uz.malis.crudinspringboot.model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {
//  List<Users> findByLastName(String lastName);
}
