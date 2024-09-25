package api_users.mapper;

import api_users.dtos.request.RequestSaveUser;
import api_users.dtos.response.ResponseSaveUser;
import api_users.dtos.response.ResponseUser;
import api_users.model.UserModel;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

  @Mapping(target = "username", source = "username")
  @Mapping(target = "phone", source = "phone")
  UserModel toUserModel(RequestSaveUser requestSaveUser);


  @Mapping(target = "username", source = "userModel.username")
  @Mapping(target = "email", source = "userModel.email")
  @Mapping(target = "phone", source = "userModel.phone")
  List<ResponseUser> toResponseUsersList(List<UserModel> userModelList);


  @Mapping(target = "username", source = "userModel.username")
  @Mapping(target = "phone", source = "userModel.phone")
  ResponseSaveUser toResponseSaveUser(UserModel userModel);


}
