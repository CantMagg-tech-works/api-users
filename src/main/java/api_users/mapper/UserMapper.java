package api_users.mapper;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseSaveUser;
import api_users.model.UserModel;
import java.util.UUID;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "username", source = "userModel.username")
  @Mapping(target = "phone", source = "userModel.phone")
  ResponseSaveUser toResponseSaveUser(UserModel userModel);

  @Mapping(target = "username", source = "username")
  @Mapping(target = "phone", source = "phone")
  UserModel toUserModel(RequestSaveUser requestSaveUser);

}
