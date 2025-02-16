package user.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.dto.UserResponseDto;
import user.model.User;
import user.repository.UserRepository;

@Service
@AllArgsConstructor
public class UserService {

  private final UserRepository userRepository;

  public List<UserResponseDto> getAll() {
    return userRepository.findAll().stream()
        .map(UserResponseDto::new)
        .collect(Collectors.toList());
  }

  public void create(User user) {
    userRepository.save(user);
  }

  public UserResponseDto getById(Long id) {
    return new UserResponseDto(userRepository.getById(id));
  }

  @Transactional
  public void update(User user) {
    userRepository.save(user);
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

}
