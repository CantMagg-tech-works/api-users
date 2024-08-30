package api_users.dtos.response;

import java.io.Serializable;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUsers implements Serializable {

   private UUID id;
   private String username;
   private Integer role;
   private Boolean valid;
}
