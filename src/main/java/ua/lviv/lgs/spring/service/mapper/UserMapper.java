package ua.lviv.lgs.spring.service.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ua.lviv.lgs.spring.domain.User;
import ua.lviv.lgs.spring.domain.UserDetailsImpl;
import ua.lviv.lgs.spring.dto.UserDTO;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(UserDTO userDTO);

    UserDTO toDto(User user);

    @Mapping(target = "enabled", source = "isEnabled")
    UserDetailsImpl toUserDetails(User user, boolean isEnabled);
}



