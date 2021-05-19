package com.marianowinar.warmup.repository;

import com.marianowinar.warmup.model.Role;
import com.marianowinar.warmup.model.enums.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    public boolean existsByRole(Role role);
    public Optional<Role> findByRole(RoleName roleAdmin);
}
