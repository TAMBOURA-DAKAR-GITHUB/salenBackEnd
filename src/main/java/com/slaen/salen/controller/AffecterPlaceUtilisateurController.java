package com.slaen.salen.controller;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.service.ImpSalenInterface.TestPlaceToUser;
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
    public void PlaceToUtilisateur(@RequestBody TestPlaceToUser testPlaceToUser){

        long idutilisateur= (long)  Integer.parseInt(testPlaceToUser.getUtilisateur());

        for (long i : testPlaceToUser.getPlace()) {
            affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(idutilisateur , i);
        }
    }
}
