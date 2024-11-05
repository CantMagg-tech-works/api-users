package api_users.handlers;

import api_users.dtos.response.ErrorDTO;
import api_users.dtos.response.ListErrorDTO;
import api_users.enums.UserError;
import api_users.exception.RepeatUsernameException;
import api_users.exception.UsernameAlreadyAssignedException;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalHandlers {

  @ExceptionHandler(RepeatUsernameException.class)
  public ResponseEntity<ErrorDTO> repeatUserHandler(RepeatUsernameException e) {
    log.error(UserError.USER_ERROR_0001.getDescription(), e);
    ErrorDTO error = ErrorDTO.builder()
        .code(UserError.USER_ERROR_0001.name())
        .message(UserError.USER_ERROR_0001.getDescription())
        .status(HttpStatus.BAD_REQUEST.value())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<ListErrorDTO> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
      List<String> errors = e.getBindingResult().getFieldErrors().stream().map(
          DefaultMessageSourceResolvable::getDefaultMessage).toList();

      log.error(UserError.USER_ERROR_0002.getDescription(), e);
      ErrorDTO error = ErrorDTO.builder()
          .code(UserError.USER_ERROR_0002.name())
          .message(UserError.USER_ERROR_0002.getDescription())
          .status(HttpStatus.BAD_REQUEST.value())
          .build();

      ListErrorDTO listError = ListErrorDTO.builder()
          .error(error)
          .errors(errors)
          .build();
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(listError);
  }

  @ExceptionHandler(UsernameAlreadyAssignedException.class)
  public ResponseEntity<ErrorDTO> usernameAlreadyAssignedHandler(UsernameAlreadyAssignedException e) {
    log.error(UserError.USER_ERROR_0003.getDescription(), e);
    ErrorDTO error = ErrorDTO.builder()
        .code(UserError.USER_ERROR_0003.name())
        .message(UserError.USER_ERROR_0003.getDescription())
        .status(HttpStatus.BAD_REQUEST.value())
        .build();
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
  }
}
