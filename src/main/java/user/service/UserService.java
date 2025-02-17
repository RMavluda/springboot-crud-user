package user.service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import user.dto.UserResponseDto;
import user.model.User;
import user.repository.UserRepository;

@Service
@AllArgsConstructor
@Slf4j
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

  public Optional<UserResponseDto> getById(Long id) throws BadRequestException {
    try {
      return userRepository.findById(id).map(UserResponseDto::new);
    } catch (Exception e) {
      log.info("User not found with id {}", id);
      throw new BadRequestException(e.getMessage());
    }
  }


  @Transactional
  public void update(User user) {
    userRepository.save(user);
  }

  public void deleteById(Long id) {
    userRepository.deleteById(id);
  }

}
