package user.controller;

import java.util.Optional;
import org.springframework.web.bind.annotation.RequestMapping;
import user.model.User;
import user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;

@RequestMapping("/user-management")
@Controller
public class UserController {

  private final UserService userService;

  @Autowired
  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/users")
  public String findAll(Model model) {
    List<User> users = userService.findAll();
    model.addAttribute("users", users);
    return "user-list"; // Просто отображаем страницу user-list.html
  }

  @PostMapping("/user-create")
  public String createUser(User user) {
    userService.saveUser(user);
    return "redirect:/user-management/users"; // Перенаправляем на список пользователей
  }

  @GetMapping("/user-delete/{id}")
  public String deleteUser(@PathVariable("id") Long id) {
    userService.deleteById(id);
    return "redirect:/user-management/users"; // Перенаправляем на список
  }

  @GetMapping("/user-update/{id}")
  public String updateUserForm(@PathVariable("id") Long id, Model model) {
    Optional<User> user = userService.findById(id);
    model.addAttribute("user", user.orElse(null));
    return "user-update"; // Показываем страницу редактирования
  }

  @PostMapping("/user-update")
  public String updateUser(User user) {
    userService.saveUser(user);
    return "redirect:/user-management/users"; // После обновления идём на список пользователей
  }
}
