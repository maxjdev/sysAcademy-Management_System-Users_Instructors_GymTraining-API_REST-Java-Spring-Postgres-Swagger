package com.sysAcademy.utils.converter.user_convert;

import com.sysAcademy.dto.UserDTO;
import com.sysAcademy.entity.User;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class DTOToUserConverter implements Function<UserDTO, User> {
    @Override
    public User apply(UserDTO userDTO) {
        return new User(
                userDTO.getName(),
                userDTO.getCpf(),
                userDTO.getAddress()
        );
    }
}