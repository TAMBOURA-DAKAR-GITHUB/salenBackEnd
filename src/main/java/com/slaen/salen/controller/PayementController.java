package com.slaen.salen.controller;


import com.slaen.salen.model.Payement;
import com.slaen.salen.dto.PlaceMarchandPayement;
import com.slaen.salen.service.Saleninterface.PayementInterface;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payement")
public class PayementController {

    private PayementInterface payementInterface;

    public PayementController(PayementInterface payementInterface) {
        this.payementInterface = payementInterface;
    }


    @GetMapping("/listePayement")
    public List<Payement> listePayement() {
        return payementInterface.listePayement();
    }

    @GetMapping("/listeById/{id}")
    public Payement listeById(@PathVariable(name = "id") Long id) {
        return payementInterface.listeById(id);
    }

    @PutMapping("/updatePayement/{id}")
    public Payement updatePayement(@PathVariable(name = "id") Long id, @RequestBody Payement payement) {
        payement.setIdPayement(id);
        return payementInterface.UpdatePayement(payement);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        payementInterface.deletePayement(id);
    }

    @GetMapping("/listeMarchandByUtilisateur/{id}")
    public ArrayList<Object> listeMarchandByUtilisateur(@PathVariable(name = "id") Long id) {
        return payementInterface.ListeMarchandByUtilisateur(id);
    }

    @GetMapping("/listePlaceByMarchand/{id}")
    public ArrayList<Object> listePlaceByMarchand(@PathVariable(name = "id") Long id) {
        return payementInterface.ListePlaceByMarchand(id);
    }

    @PostMapping(value = "/addPayement")
    public void addPayement(@RequestBody PlaceMarchandPayement placeMarchandPayement) {
        long idutilisateur = (long) Integer.parseInt(placeMarchandPayement.getUtilisateur());
        long idmarchand = (long) Integer.parseInt(placeMarchandPayement.getMarchand());
        double montant = placeMarchandPayement.getMontant();
        //System.out.println(montant);

        //System.out.println("utilisateur :"+idutilisateur);
        //System.out.println("marchand "+idmarchand);
        //System.out.println(placeMarchandPayement.getDatePayement());
        //System.out.println(placeMarchandPayement.getMontant());
        //System.out.println(placeMarchandPayement.getReste());

        for (long place : placeMarchandPayement.getPlaces()) {
            System.out.println("=========place ==========");
            try {
                payementInterface.addPayement(idutilisateur,idmarchand,place,montant);
            }catch (Exception e){

                e.getMessage();
                System.out.println("Probleme ....");
            }

        }


    }
}
