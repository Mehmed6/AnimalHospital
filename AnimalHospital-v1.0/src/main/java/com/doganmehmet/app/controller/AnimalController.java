package com.doganmehmet.app.controller;

import com.doganmehmet.app.dto.animal.AnimalDTO;
import com.doganmehmet.app.dto.animal.AnimalRequest;
import com.doganmehmet.app.service.AnimalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/animal")
public class AnimalController {
    private final AnimalService m_animalService;

    public AnimalController(AnimalService animalService)
    {
        m_animalService = animalService;
    }

    @PostMapping("/save")
    public AnimalDTO saveAnimal(@RequestBody AnimalRequest animalRequest)
    {
        return m_animalService.saveAnimal(animalRequest);
    }

    @GetMapping("/find/id/{animalId}")
    public AnimalDTO findById(@PathVariable long animalId)
    {
        return m_animalService.findAnimalById(animalId);
    }

    @GetMapping("/find/name/{animalName}")
    public AnimalDTO findByName(@PathVariable String animalName)
    {
        return m_animalService.findAnimalByName(animalName);
    }

    @GetMapping("/find/all")
    public List<AnimalDTO> findAll()
    {
        return m_animalService.findAllAnimals();
    }

    @GetMapping("/find/sterilize/{sterilize}")
    public List<AnimalDTO> findAllBySterilize(@PathVariable boolean sterilize)
    {
        return m_animalService.findAnimalsBySterilize(sterilize);
    }

    @GetMapping("/find/type/{type}")
    public List<AnimalDTO> findAllByType(@PathVariable String type)
    {
        return m_animalService.findAnimalsByType(type);
    }

    @GetMapping("/find/owner/{ownerId}")
    public List<AnimalDTO> findAllByOwnerId(@PathVariable long ownerId)
    {
        return m_animalService.findAnimalsByOwnerId(ownerId);
    }

    @DeleteMapping("/delete/{animalId}")
    public void deleteById(@PathVariable long animalId)
    {
        m_animalService.deleteAnimalById(animalId);
    }
}
