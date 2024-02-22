package com.sysAcademy.utils.converter.user_convert;

import com.sysAcademy.dto.UserDTO;
import com.sysAcademy.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class UserToDTOConverter implements Function<User, UserDTO> {
    @Override
    public UserDTO apply(User user) {
        return new UserDTO(
                user.getName(),
                user.getCpf(),
                user.getAddress());
    }
}