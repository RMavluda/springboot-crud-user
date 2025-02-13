package user.service;

import java.util.List;
import java.util.Optional;
import user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.repository.UserRepository;

@Service
public class UserService {
  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public List<User> findAll(){
    return userRepository.findAll();
  }
  public void saveUser(User user) {
    userRepository.save(user);
  }
  public Optional<User> findById(Long id) {
    return userRepository.findById(id);
  }
  public void deleteById(Long id){

    userRepository.deleteById(id);
  }

}
