package com.slaen.salen.repository;


import com.slaen.salen.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;


public interface UtilisateurRepository extends JpaRepository<Utilisateur , Long> {

    //public Page<Utilisateur> listeUtilisateurByPage(Pageable pageable);
    Utilisateur findByCodeUtilisateur(String code);
    Utilisateur findByIdUtilisateur(long id);

    public List<Utilisateur> findByMairieIdMairie(Long id);
}
