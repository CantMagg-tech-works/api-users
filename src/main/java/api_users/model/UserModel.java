package api_users.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ec_user")
public class UserModel {

  @Id
  @Column(name = "user_id")
  private UUID userId;
  @Column(name = "user_role")
  private String userRole;
  @Column(name = "username")
  private String username;
  @Column(name = "email")
  private String email;
  @Column(name = "phone")
  private String phone;
  @Column(name = "creation_date")
  private Date creationDate;
  @Column(name = "deleted_at")
  private Date deletedAt;

}
