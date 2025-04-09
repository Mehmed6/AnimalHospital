package com.doganmehmet.app.dto.owner;

import com.doganmehmet.app.dto.animal.AnimalDTO;
import com.doganmehmet.app.dto.animal.AnimalDTOWithOutOwnerName;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Set;

@Getter
@Setter
public class OwnerDTO {

    private String name;
    private String phone;
    private String address;
    private Set<AnimalDTOWithOutOwnerName> animals;
}
