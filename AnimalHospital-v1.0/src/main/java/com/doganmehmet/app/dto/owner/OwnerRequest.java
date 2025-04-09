package com.doganmehmet.app.dto.owner;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OwnerRequest {

    @NotBlank(message = "Name cannot be empty!")
    private String name;
    @NotBlank(message = "Phone cannot be empty!")
    private String phone;
    @NotBlank(message = "Address cannot be empty!")
    private String address;
}
