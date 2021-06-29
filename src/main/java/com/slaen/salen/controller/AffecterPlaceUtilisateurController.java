package com.slaen.salen.controller;

import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/placeToUtilisateur")
public class AffecterPlaceUtilisateurController {


    private AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository;

    public AffecterPlaceUtilisateurController(AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository) {
        this.affecterPlaceUtilisateurRepository = affecterPlaceUtilisateurRepository;
    }

    @PostMapping("/placeToUtilisateur")
    public void PlaceToUtilisateur(@RequestBody Utilisateur utilisateur ,@RequestBody Place place){
        affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(utilisateur, place);

    }
}
