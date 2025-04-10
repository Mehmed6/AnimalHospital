package com.doganmehmet.app.repository;

import com.doganmehmet.app.entity.Veterinarian;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface IVeterinarianRepository extends JpaRepository<Veterinarian, Long> {
    boolean existsByCitizenId(String citizenId);

    Optional<Veterinarian> findByCitizenId(String citizenId);

    List<Veterinarian> findByFirstName(String firstName);

    List<Veterinarian> findByBirthDate(LocalDate birthDate);

    void deleteByCitizenId(String citizenId);
}
