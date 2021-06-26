package com.slaen.salen.repository;

import com.slaen.salen.entity.Payement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PayementRepository extends JpaRepository<Payement , Long> {
}
