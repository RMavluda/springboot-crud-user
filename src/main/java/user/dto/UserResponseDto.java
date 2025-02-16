package user.dto;

import lombok.Getter;
import lombok.Setter;
import user.model.User;

@Getter
@Setter
public class UserResponseDto {
  private Long id;
  private String firstName;
  private String lastName;

  public UserResponseDto(User user) {
    this.id = user.getId();
    this.firstName = user.getFirstName();
    this.lastName = user.getLastName();
  }
}
