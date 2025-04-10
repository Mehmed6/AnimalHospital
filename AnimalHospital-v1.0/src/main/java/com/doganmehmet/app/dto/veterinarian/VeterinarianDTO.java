package com.doganmehmet.app.dto.veterinarian;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class VeterinarianDTO {

    private long diplomaNo;
    private String citizenId;
    private String firstName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String middleName;
    private String lastName;
    private LocalDate birthDate;
    private LocalDate registerDate;

}
