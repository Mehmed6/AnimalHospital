package com.doganmehmet.app.dto.veterinarian;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VeterinarianRequest {

    @NotNull(message = "Diploma number cannot be null!")
    private long diplomaNo;
    @NotBlank(message = "Citizen ID cannot be empty!")
    private String citizenId;
    @NotBlank(message = "First name cannot be empty!")
    private String firstName;
    @NotBlank(message = "Middle name cannot be empty!")
    private String middleName;
    @NotBlank(message = "Last name cannot be empty!")
    private String lastName;
    @NotNull(message = "Birth date cannot be null!")
    private LocalDate birthDate;
}
