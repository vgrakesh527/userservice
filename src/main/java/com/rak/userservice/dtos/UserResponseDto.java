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
    private List<Role> roles;

    public static UserResponseDto from(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        dto.setRoles(user.getRoles());
        return dto;
    }
}
