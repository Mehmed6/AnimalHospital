package com.doganmehmet.app.controller;

import com.doganmehmet.app.dto.veterinarian.VeterinarianDTO;
import com.doganmehmet.app.dto.veterinarian.VeterinarianRequest;
import com.doganmehmet.app.service.VeterinarianService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/veterinarian")
public class VeterinarianController {
    private final VeterinarianService m_veterinarianService;

    public VeterinarianController(VeterinarianService veterinarianService)
    {
        m_veterinarianService = veterinarianService;
    }

    @PostMapping("/save")
    public VeterinarianDTO save(@RequestBody VeterinarianRequest veterinarianRequest)
    {
        return m_veterinarianService.save(veterinarianRequest);
    }

    @GetMapping("/find/id/{diplomaNo}")
    public VeterinarianDTO findByDiplomaNo(@PathVariable long diplomaNo)
    {
        return m_veterinarianService.findByDiplomaNo(diplomaNo);
    }

    @GetMapping("/find/citizenId/{citizenId}")
    public VeterinarianDTO findByCitizenId(@PathVariable String citizenId)
    {
        return m_veterinarianService.findByCitizenId(citizenId);
    }
    @GetMapping("/find/firstName/{firstName}")
    public List<VeterinarianDTO> findByFirstName(@PathVariable String firstName)
    {
        return m_veterinarianService.findByFirstName(firstName);
    }

    @GetMapping("/find/birthDate/{birthDate}")
    public List<VeterinarianDTO> findByBirthDate(@PathVariable LocalDate birthDate)
    {
        return m_veterinarianService.findByBirthDate(birthDate);
    }

    @GetMapping("/find/all")
    public List<VeterinarianDTO> findAll()
    {
        return m_veterinarianService.findAll();
    }

    @DeleteMapping("/delete/id/{diplomaNo}")
    public void deleteByDiplomaNo(@PathVariable long diplomaNo)
    {
        m_veterinarianService.deleteByDiplomaNo(diplomaNo);
    }

    @DeleteMapping("/delete/citizenId/{citizenId}")
    public void deleteByCitizenId(@PathVariable String citizenId)
    {
        m_veterinarianService.deleteByCitizenId(citizenId);
    }

}
