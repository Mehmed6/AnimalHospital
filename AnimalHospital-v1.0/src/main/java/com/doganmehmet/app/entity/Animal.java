package com.doganmehmet.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "animals", uniqueConstraints = @UniqueConstraint(
        columnNames = {"name", "type", "birth_date", "owner_id"}
))
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "animal_id")
    private long animalId;
    @Column(length = 100, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String type;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthdate;
    @Column(nullable = false)
    private boolean sterile;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "animal", cascade = CascadeType.ALL)
    private Set<VeterinarianToAnimal> veterinarianToAnimals;

}
