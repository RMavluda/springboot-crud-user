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

  public List<User> getAll(){
    return userRepository.findAll();
  }
  public void create(User user) {
    userRepository.save(user);
  }
  public Optional<User> getById(Long id) {
    return Optional.of(userRepository.getById(id));
  }
  public void update(User user) {
    userRepository.save(user);
  }
  public void deleteById(Long id){
    userRepository.deleteById(id);
  }

}
