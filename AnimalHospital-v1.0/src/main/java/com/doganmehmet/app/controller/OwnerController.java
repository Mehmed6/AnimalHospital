package com.doganmehmet.app.controller;

import com.doganmehmet.app.dto.owner.OwnerDTO;
import com.doganmehmet.app.dto.owner.OwnerRequest;
import com.doganmehmet.app.service.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    private final OwnerService m_ownerService;

    public OwnerController(OwnerService ownerService)
    {
        m_ownerService = ownerService;
    }

    @PostMapping("/save")
    public OwnerDTO save(@RequestBody OwnerRequest ownerRequest)
    {
        return m_ownerService.save(ownerRequest);
    }

    @GetMapping("/find/id/{ownerId}")
    public OwnerDTO findById(@PathVariable long ownerId)
    {
        return m_ownerService.findOwnerById(ownerId);
    }

    @GetMapping("/find/phone/{phone}")
    public OwnerDTO findByPhone(@PathVariable String phone)
    {
        return m_ownerService.findOwnerByPhone(phone);
    }

    @GetMapping("/find/all")
    public List<OwnerDTO> findAll()
    {
        return m_ownerService.findAllOwners();
    }

    @DeleteMapping("/delete/{ownerId}")
    public void delete(@PathVariable long ownerId)
    {
        m_ownerService.deleteOwner(ownerId);
    }

}
