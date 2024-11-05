package api_users.enums;

import lombok.Getter;

@Getter
public enum UserError {

  USER_ERROR_0001("User repeated in DB", "This user is not available, use another one."),
  USER_ERROR_0002("Validation error.", "The request contains validation errors. Review the fields and correct the errors indicated below."),
  USER_ERROR_0003("Username already assigned.", "The user already has a registered username,"),;

  private final String useCase;
  private final String description;

  UserError(String useCase, String description) {
    this.useCase = useCase;
    this.description = description;
  }
}
