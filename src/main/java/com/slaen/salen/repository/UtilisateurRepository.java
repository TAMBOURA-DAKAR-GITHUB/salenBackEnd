package com.slaen.salen.repository;


import com.slaen.salen.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UtilisateurRepository extends JpaRepository<Utilisateur , Long> {

    //public Page<Utilisateur> listeUtilisateurByPage(Pageable pageable);
    Utilisateur findByCodeUtilisateur(String code);
}
