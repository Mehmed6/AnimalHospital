package com.doganmehmet.app.repository;

import com.doganmehmet.app.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IOwnerRepository extends JpaRepository<Owner, Long> {
    Optional<Owner> findByPhone(String phone);
}
