package com.sysAcademy.service;

import com.sysAcademy.dto.UserDTO;

import java.util.List;

/**
 * @author maxdev
 */
public interface IUserService {
    List<UserDTO> findAllUsers();
    UserDTO getUserById(Long id);
    UserDTO createUser(UserDTO dto);
    UserDTO updateUser(Long id, UserDTO dto);
    void deleteUserById(Long id);
    List<UserDTO> findUsersByName(String name);
}