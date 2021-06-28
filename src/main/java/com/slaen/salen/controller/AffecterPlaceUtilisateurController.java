package com.slaen.salen.controller;

import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/placeToUtilisateur")
public class AffecterPlaceUtilisateurController {


    private AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository;

    public AffecterPlaceUtilisateurController(AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository) {
        this.affecterPlaceUtilisateurRepository = affecterPlaceUtilisateurRepository;
    }

    @PostMapping("/placeToUtilisateur")
    public void PlaceToUtilisateur(Utilisateur utilisateur , Place place){
        affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(utilisateur, place);

    }
}
