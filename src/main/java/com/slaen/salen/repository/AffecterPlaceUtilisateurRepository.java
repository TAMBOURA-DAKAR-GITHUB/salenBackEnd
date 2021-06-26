package com.slaen.salen.repository;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface AffecterPlaceUtilisateurRepository extends JpaRepository<AffecterPlaceUtilisateur , Long> {
}
