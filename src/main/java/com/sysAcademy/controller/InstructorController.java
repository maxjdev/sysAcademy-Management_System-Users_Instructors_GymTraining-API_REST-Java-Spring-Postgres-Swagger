package com.sysAcademy.controller;

import com.sysAcademy.dto.InstructorDTO;
import com.sysAcademy.service.IInstructorService;
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
@RequestMapping("/instructor")
@Tag(name = "Instructor Controller", description = "API for instructor management")
public class InstructorController {
    // DI
    private final IInstructorService service;
    public InstructorController(IInstructorService iInstructorService) {
        this.service = iInstructorService;
    }
    // Requests
    @Operation(summary = "List all instructors", description = "Return List<InstructorDTO>")
    @GetMapping
    public ResponseEntity<List<InstructorDTO>> findAllInstructors() {
        try {
            List<InstructorDTO> instructors = service.findAllInstructors();
            return ResponseEntity.ok(instructors);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Find instructor by id", description = "Return InstructorDTO")
    @GetMapping("/{id}")
    public ResponseEntity<InstructorDTO> getInstructorById(@PathVariable Long id) {
        try {
            InstructorDTO instructor = service.getInstructorById(id);
            return ResponseEntity.ok(instructor);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Create a instructor", description = "Return InstructorDTO")
    @PostMapping
    public ResponseEntity<InstructorDTO> createInstructor(@Valid @RequestBody InstructorDTO instructorDTO) {
        try {
            InstructorDTO instructorCreated = service.createInstructor(instructorDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(instructorCreated);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Update a instructor", description = "Return InstructorDTO")
    @PutMapping("/{id}")
    public ResponseEntity<InstructorDTO> updateInstructor(@PathVariable Long id, @Valid @RequestBody InstructorDTO dto) {
        try {
            InstructorDTO instructorUpdated = service.updateInstructor(id, dto);
            return ResponseEntity.ok(instructorUpdated);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @Operation(summary = "Delete a instructor", description = "Return Void")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInstructorById(@PathVariable Long id) {
        try {
            service.deleteInstructorById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}