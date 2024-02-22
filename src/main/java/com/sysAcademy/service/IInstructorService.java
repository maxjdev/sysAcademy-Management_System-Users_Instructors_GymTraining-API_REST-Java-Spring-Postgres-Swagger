package com.sysAcademy.service;

import com.sysAcademy.dto.InstructorDTO;
import java.util.List;

/**
 * @author maxdev
 */
public interface IInstructorService {
    List<InstructorDTO> findAllInstructors();
    InstructorDTO getInstructorById(Long id);
    InstructorDTO createInstructor(InstructorDTO dto);
    InstructorDTO updateInstructor(Long id, InstructorDTO dto);
    void deleteInstructorById(Long id);
}