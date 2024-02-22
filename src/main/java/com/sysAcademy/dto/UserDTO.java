package com.sysAcademy.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author maxdev
 */
@Data @AllArgsConstructor
public class UserDTO {
    @NotBlank(message = "Fill in the field correctly")
    @Size(min = 3, max = 50, message = "'${validateValue}' must have between {min} and {max} characters")
    private String name;

    @NotBlank(message = "Fill in the field correctly")
    @NotNull(message = "Fill in the field correctly")
    @Pattern(regexp = "\\d{11}", message = "CPF must contain exactly 11 digits")
    private String cpf;

    @NotBlank(message = "Fill in the field correctly")
    @Size(min = 3, max = 50, message = "'${validateValue}' must have between {min} and {max} characters")
    private String address;
}