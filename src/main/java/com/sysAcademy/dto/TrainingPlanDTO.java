package com.sysAcademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author maxdev
 */
@Data @AllArgsConstructor @NoArgsConstructor
public class TrainingPlanDTO {
    @NotBlank(message = "Fill in the field correctly")
    private String description;

    @NotNull(message = "User ID is required")
    private Long userID;

    @NotNull(message = "Instructor ID is required")
    private Long instructorID;
}