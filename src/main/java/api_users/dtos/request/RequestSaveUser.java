package api_users.dtos.request;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequestSaveUser implements Serializable {

  @NotBlank(message = "Enter a username to save.")
  private String username;

  @NotBlank(message = "Enter an phone to save.")
  @Pattern(regexp = "\\d+", message = "Invalid phone format.")
  private String phone;

}
