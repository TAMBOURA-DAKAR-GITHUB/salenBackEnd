package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.CommuneNotFountException;
import com.slaen.salen.Exception.InterceptionException.MarchandNotFountException;
import com.slaen.salen.model.Commune;
import com.slaen.salen.model.Marchand;
import com.slaen.salen.service.Saleninterface.MarchandInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/marchand")
public class MarchandController {

    private MarchandInterface marchandInterface;

    public MarchandController(MarchandInterface marchandInterface) {
        this.marchandInterface = marchandInterface;
    }

//    @PostMapping(value = "/addMarhand")
//    public Marchand addMarhand(@RequestBody Marchand marchand){
//        return marchandInterface.addMarchand(marchand);
//    }

    @PostMapping(value = "/addMarhand")
    public ResponseEntity<Object> addMarhand(@RequestBody Marchand marchand)
    {
        try {
            marchand = marchandInterface.addMarchand(marchand);
        }catch (Exception e){
            throw new MarchandNotFountException();
        }

        return new ResponseEntity<>(
                "Marchand "  + marchand.getTelephoneMarchand() +"est Creer avec success ",
                HttpStatus.CREATED);
    }


//    @GetMapping("/listeMarhand")
//    public List<Marchand> listeMarhand(){
//        return marchandInterface.listeMarchand();
//    }

    @GetMapping("/listeMarhand")
    public ResponseEntity<Object> listeMarhand()
    {
        List<Marchand> MarchandList= null;
        try {
            MarchandList = marchandInterface.listeMarchand();
        }catch (Exception e){
            throw new MarchandNotFountException();
        }

        return new ResponseEntity<>(MarchandList, HttpStatus.OK);
    }



//    @GetMapping("/listeById/{id}")
//    public  Marchand listeById(@PathVariable(name = "id") Long id){
//        return marchandInterface.listeById(id);
//    }


    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isMarchandleExist = marchandInterface.isMarchandExist(id);
        if (isMarchandleExist)
        {
            Marchand marchand=null;
            try {
                 marchand = marchandInterface.listeById(id);
            }catch (Exception e){
                throw new MarchandNotFountException();
            }

            return new ResponseEntity<>(marchand, HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }


//    @PutMapping("/updateMarhand/{id}")
//    public Marchand updateMarhand(@PathVariable(name = "id") Long id ,@RequestBody Marchand marchand){
//        marchand.setIdMarchand(id);
//        return marchandInterface.UpdateMarcher(marchand);
//    }

    @PutMapping("/updateMarhand/{id}")
    public ResponseEntity<Object> updateMarhand(@PathVariable(name = "id") Long id ,@RequestBody Marchand marchand)
    {
        boolean isMarchandleExist = marchandInterface.isMarchandExist(id);
        if (isMarchandleExist)
        {
            try {
                marchand.setIdMarchand(id);
                marchandInterface.UpdateMarcher(marchand);
            }catch (Exception e){
                throw new MarchandNotFountException();
            }

            return new ResponseEntity<>("Marchand modifier avec success", HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }

//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        marchandInterface.deleteMarchand(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isMarchandleExist = marchandInterface.isMarchandExist(id);
        if (isMarchandleExist)
        {
            try {
                marchandInterface.deleteMarchand(id);
            }catch (Exception e){
                throw new MarchandNotFountException();
            }

            return new ResponseEntity<>("Marchand Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }


//    @GetMapping("/listeMarhandByMarcher/{id}")
//    public List<Marchand> listeByMarchand(@PathVariable(name = "id") Long id){
//        return marchandInterface.listeByMarcher(id);
//    }


    @GetMapping("/listeMarhandByMarcher/{id}")
    public ResponseEntity<Object> listeByMarchand(@PathVariable(name = "id") Long id)
    {
        boolean isMarchandByMarcherleExist = marchandInterface.isMarchandByMarcherExist(id);
        if (isMarchandByMarcherleExist)
        {
            List<Marchand> listemarchand= null;
            try {
                 listemarchand = marchandInterface.listeByMarcher(id);
            }catch (Exception e){
                throw new MarchandNotFountException();
            }

            return new ResponseEntity<>(listemarchand, HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }
}
