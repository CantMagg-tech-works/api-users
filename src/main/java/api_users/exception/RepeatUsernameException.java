package api_users.exception;

import lombok.Builder;

public class RepeatUsernameException extends RuntimeException {

  @Builder
  public RepeatUsernameException(String message) {
    super(message);
  }
}
