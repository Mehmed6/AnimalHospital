package com.doganmehmet.app.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "veterinarians")
public class Veterinarian {
    @Id
    @Column(name = "diploma_no")
    private long diplomaNo;
    @Column(name = "cirizen_id", unique = true, nullable = false)
    private String citizenId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "veterinarian", cascade = CascadeType.ALL)
    private Set<VeterinarianToAnimal> veterinarianToAnimals;
}
