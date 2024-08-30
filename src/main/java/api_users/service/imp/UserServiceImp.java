package api_users.service.imp;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseSaveUser;
import api_users.mapper.UserMapper;
import api_users.model.UserModel;
import api_users.repository.UserRepository;
import api_users.service.UserService;
import java.util.Date;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public ResponseSaveUser saveUser(RequestSaveUser requestSaveUser, String userId,
      String userRole, String email) {
    UserModel userModel = UserModel.builder()
        .username(requestSaveUser.getUsername())
        .phone(requestSaveUser.getPhone())
        .userId(UUID.fromString(userId))
        .userRole(userRole)
        .email(email)
        .creationDate(new Date())
        .build();
    userRepository.save(userModel);
    return userMapper.toResponseSaveUser(userModel);
  }

  @Override
  public String getAllUsers() {
    return "all users";
  }
}



