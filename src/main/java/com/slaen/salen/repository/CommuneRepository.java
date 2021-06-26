package com.slaen.salen.repository;

import com.slaen.salen.entity.Commune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CommuneRepository extends JpaRepository<Commune , Long> {
}
