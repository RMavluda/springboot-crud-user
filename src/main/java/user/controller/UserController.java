package user.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import user.dto.UserResponseDto;
import user.model.User;
import user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RequestMapping("/user-management")
@RestController
@Tag(name = "Users")
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/getAll")
  public ResponseEntity<List<UserResponseDto>> getAll() {
    return ResponseEntity.ok(userService.getAll());
  }

  @PostMapping("/create")
  public ResponseEntity<Void> create(User user) {
    userService.create(user);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/get/{id}")
  public ResponseEntity<UserResponseDto> getById(@PathVariable Long id) throws BadRequestException {
    return userService.getById(id)
        .map(ResponseEntity::ok)
        .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found with id: " + id));
  }

  @PostMapping("/update/{id}")
  public String updateById(User user) {
    userService.update(user);
    return "redirect:/user-management/users";
  }

  @GetMapping("/delete/{id}")
  public String deleteById(@PathVariable("id") Long id) {
    userService.deleteById(id);
    return "redirect:/user-management/users";
  }
}
