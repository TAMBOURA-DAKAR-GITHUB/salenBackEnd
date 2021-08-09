package com.slaen.salen.controller;

import com.slaen.salen.dto.TestPlaceToUser;
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
        System.out.println(idutilisateur);
        for (long i : testPlaceToUser.getPlace()) {
            System.out.println(i);
            affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(idutilisateur , i);
        }
    }
}
