package com.sysAcademy.utils.converter.instructor_convert;

import com.sysAcademy.dto.InstructorDTO;
import com.sysAcademy.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class DTOToInstructorConverter implements Function<InstructorDTO, Instructor> {
    @Override
    public Instructor apply(InstructorDTO instructorDTO) {
        return new Instructor(
                instructorDTO.getName(),
                instructorDTO.getSpecialty()
        );
    }
}