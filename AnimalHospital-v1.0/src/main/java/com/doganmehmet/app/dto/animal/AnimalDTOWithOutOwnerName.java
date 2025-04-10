package com.doganmehmet.app.dto.animal;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AnimalDTOWithOutOwnerName {
    private String name;
    private String type;
    private LocalDate birthdate;
    private boolean sterile;
}
