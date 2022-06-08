package com.sinaukoding.sinaukoding.entity.mapping;

import com.sinaukoding.sinaukoding.entity.User;
import com.sinaukoding.sinaukoding.entity.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface UserMapping {
    UserMapping INSTANCE = Mappers.getMapper(UserMapping.class);

    User toEntity(UserDTO dto);

    UserDTO toDto(User user);

    List<User> toUserList(List<UserDTO> data);

    List<UserDTO> toUserDTOList(List<User> data);
}
