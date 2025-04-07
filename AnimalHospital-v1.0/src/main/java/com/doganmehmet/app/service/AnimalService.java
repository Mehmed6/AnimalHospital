package com.doganmehmet.app.service;

import com.doganmehmet.app.dto.animal.AnimalDTO;
import com.doganmehmet.app.dto.animal.AnimalRequest;
import com.doganmehmet.app.exception.ApiException;
import com.doganmehmet.app.exception.MyError;
import com.doganmehmet.app.mapper.IAnimalMapper;
import com.doganmehmet.app.repository.IAnimalRepository;
import com.doganmehmet.app.repository.IOwnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final IAnimalRepository m_animalRepository;
    private final IOwnerRepository m_ownerRepository;
    private final IAnimalMapper m_animalMapper;

    public AnimalService(IAnimalRepository animalRepository, IOwnerRepository ownerRepository, IAnimalMapper animalMapper)
    {
        m_animalRepository = animalRepository;
        m_ownerRepository = ownerRepository;
        m_animalMapper = animalMapper;
    }

    public AnimalDTO saveAnimal(AnimalRequest animalRequest)
    {
        var animal = m_animalMapper.toAnimal(animalRequest);

        var owner = m_ownerRepository.findById(animalRequest.getOwnerId())
                        .orElseThrow(() -> new ApiException(MyError.OWNER_NOT_FOUND));

        animal.setOwner(owner);

        var savedAnimal = m_animalRepository.save(animal);
        return m_animalMapper.toAnimalDTO(savedAnimal);
    }

    public AnimalDTO findAnimalById(long animalId)
    {
        var animal = m_animalRepository.findById(animalId)
                        .orElseThrow(() -> new ApiException(MyError.ANIMAL_NOT_FOUND));
        return m_animalMapper.toAnimalDTO(animal);
    }

    public AnimalDTO findAnimalByName(String name)
    {
        var animal = m_animalRepository.findByName(name)
                .orElseThrow(() -> new ApiException(MyError.ANIMAL_NOT_FOUND));

        return m_animalMapper.toAnimalDTO(animal);
    }

    public List<AnimalDTO> findAllAnimals()
    {
        var animals = m_animalRepository.findAll();
        return m_animalMapper.toAnimalDTOList(animals);
    }

    public List<AnimalDTO> findAnimalsBySterilize(boolean sterilize)
    {
        var animals = m_animalRepository.findBySterile(sterilize);
        return m_animalMapper.toAnimalDTOList(animals);
    }

    public List<AnimalDTO> findAnimalsByType(String type)
    {
        var animals = m_animalRepository.findByType(type);
        return m_animalMapper.toAnimalDTOList(animals);
    }

    public List<AnimalDTO> findAnimalsByOwnerId(long ownerId)
    {
        var owner = m_ownerRepository.findById(ownerId)
                        .orElseThrow(() -> new ApiException(MyError.OWNER_NOT_FOUND));

        var animals = m_animalRepository.findByOwner(owner);

        return m_animalMapper.toAnimalDTOList(animals);
    }

    @Transactional
    public void deleteAnimalById(long animalId)
    {
        m_animalRepository.deleteById(animalId);
    }
}
