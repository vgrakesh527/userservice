package com.rak.userservice.dtos;

import com.rak.userservice.models.Role;
import com.rak.userservice.models.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserResponseDto {
    private String name;
    private String email;
    private List<String> roles;

    public static UserResponseDto from(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles() != null ? user.getRoles().stream().map(Role::getValue).toList() : null);
        return dto;
    }
}
