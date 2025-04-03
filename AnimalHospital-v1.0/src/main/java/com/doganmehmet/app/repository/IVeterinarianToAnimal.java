package com.doganmehmet.app.repository;

import com.doganmehmet.app.entity.VeterinarianToAnimal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVeterinarianToAnimal extends JpaRepository<VeterinarianToAnimal, Long> {
}
