package com.ajaysw.repositories;

import com.ajaysw.model.AppRole;
import com.ajaysw.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByRoleName(AppRole appRole);
}
