package com.slaen.salen.controller;

import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.CercleExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.CercleNotFountException;
import com.slaen.salen.model.Cercle;
import com.slaen.salen.service.Saleninterface.CercleInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cercle")
public class CercleController {

    private CercleInterface cercleInterface;


    public CercleController(CercleInterface cercleInterface) {
        this.cercleInterface = cercleInterface;

    }

//    @PostMapping(value = "/addCercle")
//    public Cercle addCercle(@RequestBody Cercle cercle){
//        return cercleInterface.addCercle(cercle);
//    }

    @PostMapping(value = "/addCercle")
    public ResponseEntity<Object> addCercle(@RequestBody Cercle cercle)
    {
        String cercleexiste = cercle.getLibelleCercle();
        if(cercleexiste !=null && !"".equals(cercleexiste)){
            Cercle cercle1 = cercleInterface.VerificationCercle(cercleexiste);
            if(cercle1 != null){
                throw new CercleExistetException();
            }
        }
        try {
            cercle = cercleInterface.addCercle(cercle);
        }catch (Exception e){
            throw new CercleNotFountException();
        }

        return new ResponseEntity<>(
                "Cercle "  + cercle.getLibelleCercle() +"est Creer avec success ",
                HttpStatus.CREATED);
    }


//    @GetMapping("/listeCercle")
//    public List<Cercle> listeCercle(){
//        return cercleInterface.listeCercle();
//    }

    @GetMapping("/listeCercle")
    public ResponseEntity<Object> listeCercle()
    {
        List<Cercle> CercleList =null;
        try {
             CercleList = cercleInterface.listeCercle();
        }catch (Exception e){
            throw new CercleNotFountException();
        }

        return new ResponseEntity<>(CercleList, HttpStatus.OK);
    }


//    @GetMapping("/listeById/{id}")
//    public  Cercle listeById(@PathVariable(name = "id") Long id){
//        return cercleInterface.listeById(id);
//    }

    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isCercleExist = cercleInterface.isCercleExist(id);
        if (isCercleExist)
        {
            Cercle cercle = null;
            try {
                 cercle =cercleInterface.listeById(id);
            }catch (Exception e){
                throw new CercleNotFountException();
            }

            return new ResponseEntity<>(cercle, HttpStatus.OK);
        }
        else
        {
            throw new CercleNotFountException();
        }

    }
//
//    @PutMapping("/updateCercle/{id}")
//    public Cercle updateCercle(@PathVariable(name = "id") Long id ,@RequestBody Cercle cercle){
//        cercle.setIdCercle(id);
//        return cercleInterface.UpdateCercle(cercle);
//    }

    @PutMapping("/updateCercle/{id}")
    public ResponseEntity<Object> updateCercle(@PathVariable(name = "id") Long id ,@RequestBody Cercle cercle)
    {
        boolean isCercleExist = cercleInterface.isCercleExist(id);
        if (isCercleExist)
        {
            try {
                cercle.setIdCercle(id);
                cercleInterface.UpdateCercle(cercle);
            }catch (Exception e){
                throw new CercleNotFountException();
            }
            return new ResponseEntity<>("Cercle modifier avec success", HttpStatus.OK);
        }
        else
        {
            throw new CercleNotFountException();
        }

    }

//
//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        cercleInterface.deleteCercle(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isCercleExist = cercleInterface.isCercleExist(id);
        if (isCercleExist)
        {
            try {
                cercleInterface.deleteCercle(id);
            }catch (Exception e){
                throw  new CercleNotFountException();
            }

            return new ResponseEntity<>("Cercle Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new CercleNotFountException();
        }

    }
}
