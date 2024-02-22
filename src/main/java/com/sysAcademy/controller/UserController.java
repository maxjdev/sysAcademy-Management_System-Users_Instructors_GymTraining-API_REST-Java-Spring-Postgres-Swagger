package com.sysAcademy.controller;

import com.sysAcademy.dto.UserDTO;
import com.sysAcademy.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author maxdev
 */
@RestController
@RequestMapping("/users")
@Tag(name = "User Controller", description = "API for user management")
public class UserController {
    // DI
    private final IUserService service;
    public UserController(IUserService iUserService) {
        this.service = iUserService;
    }
    // Requests
    @Operation(summary = "List all users", description = "Return List<UserDTO>")
    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        try {
            List<UserDTO> users = service.findAllUsers();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Find a users by name", description = "Return List<UserDTO>")
    @GetMapping("/search")
    public ResponseEntity<List<UserDTO>> findUsersByName (@RequestParam String name) {
        try {
            List<UserDTO> users = service.findUsersByName(name);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Find user by id", description = "Return UserDTO")
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable Long id) {
        try {
            UserDTO user = service.getUserById(id);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Create a user", description = "Return UserDTO")
    @PostMapping
    public ResponseEntity<UserDTO> createUser (@Valid @RequestBody UserDTO userDTO) {
        try {
            UserDTO userCreated = service.createUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Update a user", description = "Return UserDTO")
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @Valid @RequestBody UserDTO dto) {
        try {
            UserDTO userUpdated = service.updateUser(id, dto);
            return ResponseEntity.ok(userUpdated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Delete a user", description = "Return Void")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        try {
            service.deleteUserById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}