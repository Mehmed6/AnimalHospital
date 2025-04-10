package com.doganmehmet.app.service;

import com.doganmehmet.app.dto.veterinarian.VeterinarianDTO;
import com.doganmehmet.app.dto.veterinarian.VeterinarianRequest;
import com.doganmehmet.app.exception.ApiException;
import com.doganmehmet.app.exception.MyError;
import com.doganmehmet.app.mapper.IVeterinarianMapper;
import com.doganmehmet.app.repository.IVeterinarianRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VeterinarianService {
    private final IVeterinarianRepository m_veterinarianRepository;
    private final IVeterinarianMapper m_veterinarianMapper;

    public VeterinarianService(IVeterinarianRepository veterinarianRepository, IVeterinarianMapper veterinarianMapper)
    {
        m_veterinarianRepository = veterinarianRepository;
        m_veterinarianMapper = veterinarianMapper;
    }

    public VeterinarianDTO save(VeterinarianRequest veterinarianRequest)
    {
        if (m_veterinarianRepository.existsById(veterinarianRequest.getDiplomaNo()) ||
            m_veterinarianRepository.existsByCitizenId(veterinarianRequest.getCitizenId()))
            throw new ApiException(MyError.VETERINARIAN_ALREADY_EXISTS);

        var veterinarian = m_veterinarianMapper.toVeterinarian(veterinarianRequest);
        veterinarian.setRegisterDate(LocalDate.now());

        return m_veterinarianMapper.toVeterinarianDTO(m_veterinarianRepository.save(veterinarian));
    }

    public VeterinarianDTO findByDiplomaNo(long diplomaNo)
    {
        var veterinarian = m_veterinarianRepository.findById(diplomaNo)
                .orElseThrow(() -> new ApiException(MyError.VETERINARIAN_NOT_FOUND));

        return m_veterinarianMapper.toVeterinarianDTO(veterinarian);
    }

    public VeterinarianDTO findByCitizenId(String citizenId)
    {
        var veterinarian = m_veterinarianRepository.findByCitizenId(citizenId)
                .orElseThrow(() -> new ApiException(MyError.VETERINARIAN_NOT_FOUND));

        return m_veterinarianMapper.toVeterinarianDTO(veterinarian);
    }

    public List<VeterinarianDTO> findByFirstName(String firstName)
    {
        var veterinarian = m_veterinarianRepository.findByFirstName(firstName);

        return m_veterinarianMapper.toVeterinarianDTOList(veterinarian);
    }

    public List<VeterinarianDTO> findByBirthDate(LocalDate birthDate)
    {
        var veterinarian = m_veterinarianRepository.findByBirthDate(birthDate);

        return m_veterinarianMapper.toVeterinarianDTOList(veterinarian);
    }

    public List<VeterinarianDTO> findAll()
    {
        return m_veterinarianMapper.toVeterinarianDTOList(m_veterinarianRepository.findAll());
    }

    @Transactional
    public void deleteByDiplomaNo(long diplomaNo)
    {
        if (!m_veterinarianRepository.existsById(diplomaNo))
            throw new ApiException(MyError.VETERINARIAN_NOT_FOUND);

        m_veterinarianRepository.deleteById(diplomaNo);
    }

    @Transactional
    public void deleteByCitizenId(String citizenId)
    {
        if (!m_veterinarianRepository.existsByCitizenId(citizenId))
            throw new ApiException(MyError.VETERINARIAN_NOT_FOUND);

        m_veterinarianRepository.deleteByCitizenId(citizenId);
    }
}
