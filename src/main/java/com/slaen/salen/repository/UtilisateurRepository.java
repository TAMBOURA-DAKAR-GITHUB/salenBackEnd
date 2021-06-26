package com.slaen.salen.repository;

import com.slaen.salen.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface UtilisateurRepository extends JpaRepository<Utilisateur , Long> {
}
