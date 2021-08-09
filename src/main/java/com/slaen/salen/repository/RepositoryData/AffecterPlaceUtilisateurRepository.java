package com.slaen.salen.repository.RepositoryData;

import com.slaen.salen.model.AffecterPlaceUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AffecterPlaceUtilisateurRepository extends JpaRepository<AffecterPlaceUtilisateur , Long> {

    //public Page<AffecterPlaceUtilisateur> listeAffecterUtilisateur(Pageable pageable);
     // public Utilisateur findById(long id);
}
