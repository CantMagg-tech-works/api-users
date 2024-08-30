package api_users.service;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseSaveUser;

public interface UserService {

  ResponseSaveUser saveUser(RequestSaveUser requestSaveUser, String userId, String userRole,
      String email);

  String getAllUsers();
}
