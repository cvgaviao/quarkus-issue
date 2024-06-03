package com.task.api.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.task.api.dtos.UserDto;
import com.task.api.dtos.UserNoIdDto;
import com.task.api.entities.User;

@Mapper(config = QuarkusMappingConfig.class)
public interface UserMapper {

  List<UserDto> mapToListDto(List<User> users);

  @Mapping(target = "id", ignore = true)
  User merge(@MappingTarget User target, User source);

  @InheritInverseConfiguration
  UserDto toDto(User user);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "updatedOn", ignore = true)
  @Mapping(target = "optLock", ignore = true)
  User toEntity(UserDto userDto);

  @Mapping(target = "id", ignore = true)
  @Mapping(target = "createdBy", ignore = true)
  @Mapping(target = "updatedBy", ignore = true)
  @Mapping(target = "createdOn", ignore = true)
  @Mapping(target = "updatedOn", ignore = true)
  @Mapping(target = "optLock", ignore = true)
  User toNoIdEntity(UserNoIdDto userNoIdDto);
}
