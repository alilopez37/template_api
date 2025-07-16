package org.alilopez.mapper;

import org.alilopez.dto.UserDTO;
import org.alilopez.model.User;

public class UserMapper {
    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getUsername(), user.getEmail());
    }

    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.name);
        user.setEmail(dto.email);
        return user;
    }
}
