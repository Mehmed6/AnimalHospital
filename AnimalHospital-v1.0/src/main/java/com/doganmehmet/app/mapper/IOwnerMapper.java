package com.doganmehmet.app.mapper;

import com.doganmehmet.app.dto.owner.OwnerDTO;
import com.doganmehmet.app.dto.owner.OwnerRequest;
import com.doganmehmet.app.entity.Owner;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(implementationName = "OwnerMapperImpl", componentModel = "spring")
public interface IOwnerMapper {

    Owner toOwner(OwnerRequest request);

    OwnerDTO toOwnerDTO(Owner owner);

    List<OwnerDTO> toOwnerDTOList(List<Owner> owners);
}
