package com.doganmehmet.app.mapper;

import com.doganmehmet.app.dto.animal.AnimalDTO;
import com.doganmehmet.app.dto.animal.AnimalRequest;
import com.doganmehmet.app.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(implementationName = "AnimalMapperImpl", componentModel = "spring")
public interface IAnimalMapper {

    @Mapping(target = "owner", ignore = true)
    Animal toAnimal(AnimalRequest animalRequest);

    @Mapping(target = "ownerName", source = "owner.name")
    AnimalDTO toAnimalDTO(Animal animal);

    List<AnimalDTO> toAnimalDTOList(List<Animal> animals);
}
