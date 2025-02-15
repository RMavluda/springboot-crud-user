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

  @GetMapping("/getAll")
  public String getAll(Model model) {
    List<User> users = userService.getAll();
    model.addAttribute("users", users);
    return "user-list";
  }

  @PostMapping("/create")
  public String create(User user) {
    userService.create(user);
    return "redirect:/user-management/users";
  }

  @GetMapping("/get/{id}")
  public String getById(@PathVariable("id") Long id, Model model) {
    Optional<User> user = userService.getById(id);
    model.addAttribute("user", user.orElse(null));
    return "user-update";
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
