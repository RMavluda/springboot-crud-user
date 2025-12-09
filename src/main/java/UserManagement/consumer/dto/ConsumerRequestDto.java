package UserManagement.consumer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ConsumerRequestDto {

  private String firstName;
  private String lastName;
  private String address;
  private String phone;
  private String email;
}
