package com.doganmehmet.app.mapper;

import com.doganmehmet.app.dto.veterinarian.VeterinarianDTO;
import com.doganmehmet.app.dto.veterinarian.VeterinarianRequest;
import com.doganmehmet.app.entity.Veterinarian;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "VeterinarianMapperImpl", componentModel = "spring")
public interface IVeterinarianMapper {

    Veterinarian toVeterinarian(VeterinarianRequest veterinarianRequest);
    VeterinarianDTO toVeterinarianDTO(Veterinarian veterinarian);
    List<VeterinarianDTO> toVeterinarianDTOList(List<Veterinarian> veterinarians);
}
