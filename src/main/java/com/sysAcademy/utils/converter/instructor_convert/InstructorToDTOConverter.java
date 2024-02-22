package com.sysAcademy.utils.converter.instructor_convert;

import com.sysAcademy.dto.InstructorDTO;
import com.sysAcademy.entity.Instructor;
import org.springframework.stereotype.Component;

import java.util.function.Function;

/**
 * @author maxdev
 */
@Component
public class InstructorToDTOConverter implements Function<Instructor, InstructorDTO> {
    @Override
    public InstructorDTO apply(Instructor instructor) {
        return new InstructorDTO(
                instructor.getName(),
                instructor.getSpecialty()
        );
    }
}