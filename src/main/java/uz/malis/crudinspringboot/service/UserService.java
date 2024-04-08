package uz.malis.crudinspringboot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.malis.crudinspringboot.model.User;
import uz.malis.crudinspringboot.repository.UserRepository;

@Service
public class UserService {

  private final UserRepository userRepository;

  @Autowired
  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User findById(Long id){
    return userRepository.getOne(id);
  }
  public List<User> findAll(){
    return userRepository.findAll();
  }
  public void saveUser(User user){
    userRepository.save(user);
  }
  public void deleteById(Long id){
    userRepository.deleteById(id);
  }

}
