package api_users.controller;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseSaveUser;
import api_users.service.UserService;
import java.util.Collections;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping("/authorized")
  public Map<String, String> handleCallback(@RequestParam String code) {
    return Collections.singletonMap("code", code);
  }

  @PostMapping("/users")
  public ResponseSaveUser saveUser(@RequestBody RequestSaveUser requestSaveUser,
      @AuthenticationPrincipal Jwt jwt) {
    String userId = jwt.getClaims().get("user_id").toString();
    String userRole = jwt.getClaims().get("role").toString();
    String email = jwt.getClaims().get("username").toString();

    return userService.saveUser(requestSaveUser, userId, userRole, email);
  }

  @GetMapping("/users")
  public String getAllUsers() {
    return userService.getAllUsers();
  }

}
