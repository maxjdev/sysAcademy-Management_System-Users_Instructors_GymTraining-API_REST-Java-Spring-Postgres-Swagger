package com.sysAcademy.service.impl;

import com.sysAcademy.dto.InstructorDTO;
import com.sysAcademy.entity.Instructor;
import com.sysAcademy.repository.InstructorRepository;
import com.sysAcademy.service.IInstructorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author maxdev
 */
@Service
public class InstructorService implements IInstructorService {
    // DI
    private final InstructorRepository repository;
    private final Function<Instructor, InstructorDTO> toDTO;
    private final Function<InstructorDTO, Instructor> toEntity;
    public InstructorService(
            InstructorRepository repository,
            Function<Instructor, InstructorDTO> toDTO,
            Function<InstructorDTO, Instructor> toEntity
    ) {
        this.repository = repository;
        this.toDTO = toDTO;
        this.toEntity = toEntity;
    }
    // Methods
    @Override
    public List<InstructorDTO> findAllInstructors() {
        List<Instructor> instructors = repository.findAll();
        return instructors.stream()
                .map(toDTO)
                .collect(Collectors.toList());
    }
    @Override
    public InstructorDTO getInstructorById(Long id) {
        Instructor instructor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> Instructor " + id + " not found <***"));
        return toDTO.apply(instructor);
    }
    @Override
    public InstructorDTO createInstructor(InstructorDTO dto) {
        Instructor instructor = toEntity.apply(dto);
        Instructor instructorSaved = repository.save(instructor);
        return toDTO.apply(instructorSaved);
    }
    @Override
    public InstructorDTO updateInstructor(Long id, InstructorDTO dto) {
        Instructor instructor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> Instructor " + id + " not found <***"));
        instructor.setName(dto.getName());
        instructor.setSpecialty(dto.getSpecialty());
        Instructor instructorUpdated = repository.save(instructor);
        return toDTO.apply(instructorUpdated);
    }
    @Override
    public void deleteInstructorById(Long id) {
        Instructor instructor = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("***> Instructor " + id + " not found <***"));
        repository.delete(instructor);
    }
}