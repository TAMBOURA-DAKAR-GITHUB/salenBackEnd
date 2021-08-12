package com.slaen.salen.controller;

import com.slaen.salen.Exception.InterceptionException.AffecterPlaceUtilisateurNotFountException;
import com.slaen.salen.dto.TestPlaceToUser;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/placeToUtilisateur")
public class AffecterPlaceUtilisateurController {


    private AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository;

    public AffecterPlaceUtilisateurController(AffecterPlaceUtilisateurInterface affecterPlaceUtilisateurRepository) {
        this.affecterPlaceUtilisateurRepository = affecterPlaceUtilisateurRepository;
    }


//    @PostMapping("/placeToUtilisateur")
//    public void PlaceToUtilisateur(@RequestBody TestPlaceToUser testPlaceToUser){
//
//        long idutilisateur= (long)  Integer.parseInt(testPlaceToUser.getUtilisateur());
//        System.out.println(idutilisateur);
//        for (long i : testPlaceToUser.getPlace()) {
//            System.out.println(i);
//            affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(idutilisateur , i);
//        }
//    }

    @PostMapping("/placeToUtilisateur")
    public ResponseEntity<Object> PlaceToUtilisateur(@RequestBody TestPlaceToUser testPlaceToUser)
    {
        try {
            long idutilisateur= (long)  Integer.parseInt(testPlaceToUser.getUtilisateur());
            System.out.println(idutilisateur);
            for (long i : testPlaceToUser.getPlace()) {
                System.out.println(i);
                affecterPlaceUtilisateurRepository.AffecterPlaceToUtilisateur(idutilisateur , i);
            }
        }catch (Exception e){
            throw new AffecterPlaceUtilisateurNotFountException();
        }
        return new ResponseEntity<>(
                "Affectation effectue avec success ",
                HttpStatus.CREATED);

    }
}
