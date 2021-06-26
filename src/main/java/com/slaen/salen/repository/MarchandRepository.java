package com.slaen.salen.repository;

import com.slaen.salen.entity.Marchand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface MarchandRepository extends JpaRepository<Marchand , Long> {
}
