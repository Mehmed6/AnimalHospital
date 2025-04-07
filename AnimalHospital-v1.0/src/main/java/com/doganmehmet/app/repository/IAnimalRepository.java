package com.doganmehmet.app.repository;

import com.doganmehmet.app.entity.Animal;
import com.doganmehmet.app.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IAnimalRepository extends JpaRepository<Animal, Long> {
    List<Animal> findBySterile(boolean sterile);

    List<Animal> findByType(String type);

    List<Animal> findByOwner(Owner owner);

    Optional<Animal> findByName(String name);
}
