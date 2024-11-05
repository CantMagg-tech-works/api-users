package api_users.service.imp;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseGetAllUsers;
import api_users.dtos.response.ResponseSaveUser;
import api_users.enums.UserError;
import api_users.exception.RepeatUsernameException;
import api_users.exception.UsernameAlreadyAssignedException;
import api_users.mapper.UserMapper;
import api_users.model.UserModel;
import api_users.repository.UserRepository;
import api_users.service.UserService;
import java.util.Date;
import java.util.List;
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

    if (userRepository.existsByUsername(requestSaveUser.getUsername().trim())) {
      throw new RepeatUsernameException(UserError.USER_ERROR_0001.getDescription());
    }
    if (userRepository.existsByUserId(UUID.fromString(userId))) {
      throw new UsernameAlreadyAssignedException(UserError.USER_ERROR_0003.getDescription());
    }
    UserModel userModel = UserModel.builder()
        .username(requestSaveUser.getUsername().trim())
        .phone(requestSaveUser.getPhone().trim())
        .userId(UUID.fromString(userId))
        .userRole(userRole)
        .email(email.trim())
        .creationDate(new Date())
        .build();
    userRepository.save(userModel);

    return userMapper.toResponseSaveUser(userModel);
  }

  @Override
  public ResponseGetAllUsers getAllUsers() {
    List<UserModel> userModels = userRepository.findAll();

    return ResponseGetAllUsers.builder().users(userMapper.toResponseUsersList(userModels)).build();
  }

}



