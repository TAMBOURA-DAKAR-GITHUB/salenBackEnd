package com.slaen.salen.SalenSecurity.repository;


import com.slaen.salen.SalenSecurity.models.ERole;
import com.slaen.salen.SalenSecurity.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}
