package com.doganmehmet.app.service;

import com.doganmehmet.app.dto.owner.OwnerDTO;
import com.doganmehmet.app.dto.owner.OwnerRequest;
import com.doganmehmet.app.exception.ApiException;
import com.doganmehmet.app.exception.MyError;
import com.doganmehmet.app.mapper.IOwnerMapper;
import com.doganmehmet.app.repository.IOwnerRepository;
import jdk.dynalink.linker.LinkerServices;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final IOwnerRepository m_ownerRepository;
    private final IOwnerMapper m_ownerMapper;

    public OwnerService(IOwnerRepository ownerRepository, IOwnerMapper ownerMapper)
    {
        m_ownerRepository = ownerRepository;
        m_ownerMapper = ownerMapper;
    }

    public OwnerDTO save(OwnerRequest ownerRequest)
    {
        var owner = m_ownerMapper.toOwner(ownerRequest);

        return m_ownerMapper.toOwnerDTO(m_ownerRepository.save(owner));
    }

    public OwnerDTO findOwnerById(long ownerId)
    {
        var owner = m_ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ApiException(MyError.OWNER_NOT_FOUND));

        return m_ownerMapper.toOwnerDTO(owner);
    }

    public OwnerDTO findOwnerByPhone(String phone)
    {
        var owner = m_ownerRepository.findByPhone(phone)
                .orElseThrow(() -> new ApiException(MyError.OWNER_NOT_FOUND));

        return m_ownerMapper.toOwnerDTO(owner);
    }

    public List<OwnerDTO> findAllOwners()
    {
        return m_ownerMapper.toOwnerDTOList(m_ownerRepository.findAll());
    }

    public void deleteOwner(long ownerId)
    {
        var owner = m_ownerRepository.findById(ownerId)
                .orElseThrow(() -> new ApiException(MyError.OWNER_NOT_FOUND));
        m_ownerRepository.delete(owner);
    }
}
