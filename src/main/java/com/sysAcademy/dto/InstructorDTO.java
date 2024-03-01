package com.sysAcademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maxdev
 */
@Data @AllArgsConstructor
public class InstructorDTO {
    @NotBlank(message = "Fill in the field correctly")
    @Size(min = 3, max = 50, message = "'${validateValue}' must have between {min} and {max} characters")
    private String name;

    @NotBlank(message = "Fill in the field correctly")
    @Size(min = 3, max = 30, message = "'${validateValue}' must have between {min} and {max} characters")
    private String specialty;
}