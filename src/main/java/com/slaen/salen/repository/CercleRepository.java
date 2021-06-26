package com.slaen.salen.repository;

import com.slaen.salen.entity.Cercle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface CercleRepository extends JpaRepository<Cercle , Long> {
}
