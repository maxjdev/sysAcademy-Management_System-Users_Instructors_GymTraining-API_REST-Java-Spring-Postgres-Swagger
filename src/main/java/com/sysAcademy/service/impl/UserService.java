package com.sysAcademy.service.impl;

import com.sysAcademy.dto.UserDTO;
import com.sysAcademy.entity.User;
import com.sysAcademy.repository.UserRepository;
import com.sysAcademy.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;

/**
 * @author maxdev
 */
@Service
public class UserService implements IUserService {
    // DI
    private final UserRepository repository;
    private final Function<User, UserDTO> toDTO;
    private final Function<UserDTO, User> toEntity;
    public UserService(
            UserRepository repository,
            Function<User, UserDTO> toDTO,
            Function<UserDTO, User> toEntity
    ) {
        this.repository = repository;
        this.toDTO = toDTO;
        this.toEntity = toEntity;
    }
    // Methods
    @Override
    public List<UserDTO> findAllUsers() {
        List<User> users = repository.findAll();
        return users.stream()
                .map(toDTO)
                .toList();
    }
    @Override
    public UserDTO getUserById(Long id) {
        return toDTO.apply(repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> User " + id + " not found <***")));
    }
    @Override
    public UserDTO createUser(UserDTO dto) {
        User user = toEntity.apply(dto);
        User userSaved = repository.save(user);
        return toDTO.apply(userSaved);
    }
    @Override
    public UserDTO updateUser(Long id, UserDTO dto) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> User " + id + " not found <***"));
        user.setAddress(dto.getAddress());
        user.setName(dto.getName());
        User userUpdated = repository.save(user);
        return toDTO.apply(userUpdated);
    }
    @Override
    public void deleteUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> User " + id + " not found <***"));
        repository.delete(user);
    }
    @Override
    public List<UserDTO> findUsersByName(String name) {
        List<User> users = repository.findUserByName(name);
        return users.stream()
                .map(toDTO)
                .toList();
    }
}