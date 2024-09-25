package api_users.exception;

import lombok.Builder;

public class UsernameAlreadyAssignedException extends RuntimeException {

  @Builder
  public UsernameAlreadyAssignedException(String message) {
    super(message);
  }

}
