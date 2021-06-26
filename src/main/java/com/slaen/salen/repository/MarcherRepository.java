package com.slaen.salen.repository;

import com.slaen.salen.entity.Marcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MarcherRepository extends JpaRepository<Marcher , Long> {
}
