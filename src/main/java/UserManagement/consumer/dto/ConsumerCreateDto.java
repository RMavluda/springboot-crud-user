package UserManagement.consumer.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ConsumerCreateDto {

  @NotBlank
  private String firstName;

  @NotBlank
  private String lastName;

  @NotBlank
  private String address;

  @NotBlank
  private String phone;

  @NotBlank
  private String email;

}
