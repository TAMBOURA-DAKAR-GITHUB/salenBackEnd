package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.CommuneExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.CommuneNotFountException;
import com.slaen.salen.model.Commune;
import com.slaen.salen.service.Saleninterface.CommuneInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/commune")
public class CommuneController {

    private CommuneInterface communeInterface;

    public CommuneController(CommuneInterface communeInterface) {
        this.communeInterface = communeInterface;
    }

//    @PostMapping(value = "/addCommune")
//    public Commune addCommune(@RequestBody Commune commune){
//        return communeInterface.addCommune(commune);
//    }

    @PostMapping(value = "/addCommune")
    public ResponseEntity<Object> addCommune(@RequestBody Commune commune)
    {
        String communeexiste = commune.getLibelleCommune();
        if(communeexiste != null && !"".equals(communeexiste)){
            Commune commune1 = communeInterface.VerificationCommune(communeexiste);
            if(commune1 != null){
                throw new CommuneExistetException();
            }
        }
        try {
            commune = communeInterface.addCommune(commune);
        }catch (Exception e){
            throw new CommuneNotFountException();
        }

        return new ResponseEntity<>(
                commune,
                HttpStatus.CREATED);
    }


//    @GetMapping("/listeCommune")
//    public List<Commune> listeCommune(){
//        return communeInterface.listeCommune();
//    }

    @GetMapping("/listeCommune")
    public ResponseEntity<Object> listeCommune()
    {
        List<Commune> CommuneList =null;
        try {
            CommuneList = communeInterface.listeCommune();
        }catch (Exception e){
            throw new CommuneNotFountException();
        }
        return new ResponseEntity<>(CommuneList, HttpStatus.OK);
    }


//    @GetMapping("/listeById/{id}")
//    public  Commune listeById(@PathVariable(name = "id") Long id){
//        return communeInterface.listeById(id);
//    }

    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isCommuneleExist = communeInterface.isCommuneExist(id);
        if (isCommuneleExist)
        {
            Commune commune =null;
            try {
                commune= communeInterface.listeById(id);
            }catch (Exception e){

            }

            return new ResponseEntity<>(commune, HttpStatus.OK);
        }
        else
        {
            throw new CommuneNotFountException();
        }

    }

//    @PutMapping("/updateCommune/{id}")
//    public Commune updateCommune(@PathVariable(name = "id") Long id ,@RequestBody Commune commune){
//        commune.setIdCommune(id);
//        return communeInterface.UpdateCommune(commune);
//    }

    @PutMapping("/updateCommune/{id}")
    public ResponseEntity<Object> updateCommune(@PathVariable(name = "id") Long id ,@RequestBody Commune commune)
    {
        boolean isCommuneleExist = communeInterface.isCommuneExist(id);
        if (isCommuneleExist)
        {
            try {
                commune.setIdCommune(id);
                communeInterface.UpdateCommune(commune);
            }catch (Exception e){
                throw new CommuneNotFountException();
            }
            return new ResponseEntity<>(commune, HttpStatus.OK);
        }
        else
        {
            throw new CommuneNotFountException();
        }

    }

//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        communeInterface.deleteCommune(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isCommuneleExist = communeInterface.isCommuneExist(id);
        if (isCommuneleExist)
        {
            try {
                communeInterface.deleteCommune(id);
            }catch (Exception e){
                throw new CommuneNotFountException();
            }
            return new ResponseEntity<>("Commune Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new CommuneNotFountException();
        }

    }
}
