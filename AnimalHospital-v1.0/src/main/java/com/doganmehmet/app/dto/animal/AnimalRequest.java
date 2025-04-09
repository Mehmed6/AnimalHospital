package com.doganmehmet.app.dto.animal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalRequest {

    @NotBlank(message = "Name cannot be empty!")
    private String name;
    @NotBlank(message = "Type cannot be empty!")
    private String type;
    @NotNull(message = "Birthdate cannot be empty!")
    private LocalDate birthdate;
    @NotNull(message = "Sterile cannot be empty!")
    private boolean sterile;
    @NotNull(message = "Owner ID cannot be empty!")
    private long ownerId;
}
