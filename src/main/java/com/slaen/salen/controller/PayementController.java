package com.slaen.salen.controller;


import com.slaen.salen.entity.Marchand;
import com.slaen.salen.entity.Payement;
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

    @PostMapping(value = "/addPayement")
    public Payement addPayement(@RequestBody Payement payement){
        return payementInterface.addPayement(payement);
    }

    @GetMapping("/listePayement")
    public List<Payement> listePayement(){
        return payementInterface.listePayement();
    }

    @GetMapping("/listeById/{id}")
    public  Payement listeById(@PathVariable(name = "id") Long id){
        return payementInterface.listeById(id);
    }

    @PutMapping("/updatePayement/{id}")
    public Payement updatePayement(@PathVariable(name = "id") Long id ,@RequestBody Payement payement){
        payement.setIdPayement(id);
        return payementInterface.UpdatePayement(payement);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id ){
        payementInterface.deletePayement(id);
    }

    @GetMapping("/listeMarchandByUtilisateur/{id}")
    public ArrayList<Object> listeMarchandByUtilisateur(@PathVariable(name = "id") Long id){
        return payementInterface.ListeMarchandByUtilisateur(id);
    }

    @GetMapping("/listePlaceByMarchand/{id}")
    public  ArrayList<Object> listePlaceByMarchand(@PathVariable(name = "id") Long id){
        return payementInterface.ListePlaceByMarchand(id);
    }
}
