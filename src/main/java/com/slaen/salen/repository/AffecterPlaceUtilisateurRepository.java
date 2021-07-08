package com.slaen.salen.repository;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public interface AffecterPlaceUtilisateurRepository extends JpaRepository<AffecterPlaceUtilisateur , Long> {

    //public Page<AffecterPlaceUtilisateur> listeAffecterUtilisateur(Pageable pageable);
     // public Utilisateur findById(long id);
}
