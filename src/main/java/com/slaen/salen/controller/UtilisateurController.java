package com.slaen.salen.controller;



import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.MairieExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.UtilisateurExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MarcherNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.PlaceNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.RegionNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.UtilisateurNotFountException;
import com.slaen.salen.model.Utilisateur;
import com.slaen.salen.service.Saleninterface.UtilisateurInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/utilisateur")
public class UtilisateurController {

    private UtilisateurInterface utilisateurInterface;

    public UtilisateurController(UtilisateurInterface utilisateurInterface) {
        this.utilisateurInterface = utilisateurInterface;
    }


//    @PostMapping(value = "/addUtilisateur")
//    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur){
//        return utilisateurInterface.addUtilisateur(utilisateur);
//    }

    @PostMapping(value = "/addUtilisateur")
    public ResponseEntity<Object> addUtilisateur(@RequestBody Utilisateur utilisateur)
    {
        String utilisateur1Existe = utilisateur.getTelephoneUtilisateur();
        if(utilisateur1Existe != null && !"".equals(utilisateur1Existe)){

           Utilisateur utilisateur1= utilisateurInterface.VerificationUtilisateur(utilisateur1Existe);
           if(utilisateur1 != null){
               throw new UtilisateurExistetException();
           }
        }
        try {
            utilisateur = utilisateurInterface.addUtilisateur(utilisateur);
        }catch (Exception e){
            throw new UtilisateurNotFountException();
        }

        return new ResponseEntity<>(
                "Utilisateur "  + utilisateur.getCodeUtilisateur() +" est Creer avec success ",
                HttpStatus.CREATED);
    }

//    @GetMapping(value = "/listeUtilisateur")
//    public List<Utilisateur> listeUtilisateur(){
//        return utilisateurInterface.listeUtilisateur();
//    }

    @GetMapping(value = "/listeUtilisateur")
    public ResponseEntity<Object> listeUtilisateur()
    {
        List<Utilisateur> UtilisateurList =null;
        try {
            UtilisateurList = utilisateurInterface.listeUtilisateur();
        }catch (Exception e){
            throw new UtilisateurNotFountException();
        }

        return new ResponseEntity<>(UtilisateurList, HttpStatus.OK);
    }


//    @GetMapping(value = "/listeById/{id}")
//    public Utilisateur ListeById(@PathVariable(name = "id") long id){
//        return   utilisateurInterface.listeById(id);
//    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id)
    {
        boolean isUtilisateurExist = utilisateurInterface.isUtilisateurExist(id);
        if (isUtilisateurExist)
        {
            Utilisateur utilisateur = null;
            try {
                utilisateur =  utilisateurInterface.listeById(id);
            }catch (Exception e){
                throw new UtilisateurNotFountException();
            }

            return new ResponseEntity<>(utilisateur, HttpStatus.OK);
        }
        else
        {
            throw new UtilisateurNotFountException();
        }

    }

//    @PutMapping(value = "/updateUtilisateur/{id}")
//    public Utilisateur updateUtilisateur(@PathVariable(name = "id") Long id, @RequestBody Utilisateur utilisateur){
//        utilisateur.setIdUtilisateur(id);
//        return utilisateurInterface.UpdateUtilisateur(utilisateur);
//    }

    @PutMapping(value = "/updateUtilisateur/{id}")
    public ResponseEntity<Object> updateUtilisateur(@PathVariable(name = "id") Long id, @RequestBody Utilisateur utilisateur)
    {
        boolean isUtilisateurExist = utilisateurInterface.isUtilisateurExist(id);
        if (isUtilisateurExist)
        {
            try {
                utilisateur.setIdUtilisateur(id);
                 utilisateurInterface.UpdateUtilisateur(utilisateur);
            }catch (Exception e){
                throw new UtilisateurNotFountException();
            }
            return new ResponseEntity<>("Utilisateur modifier avec success", HttpStatus.OK);
        }
        else
        {
            throw new UtilisateurNotFountException();
        }

    }

//    @DeleteMapping(value = "deleteById/{id}")
//    public void deleteById( @PathVariable(name = "id") Long id){
//        utilisateurInterface.deleteUtilisateur(id);
//    }

    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") Long id)
    {
        boolean isUtilisateurExist = utilisateurInterface.isUtilisateurExist(id);
        if (isUtilisateurExist)
        {
            try {
                utilisateurInterface.deleteUtilisateur(id);
            }catch (Exception e){
                throw  new RegionNotFountException();
            }

            return new ResponseEntity<>("Utilisateur Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new UtilisateurNotFountException();
        }

    }

//    @GetMapping("/listeUtilisateurById/{id}")
//    public List<Utilisateur> listeUtilisateurByMairie(@PathVariable(name = "id") Long id){
//        return utilisateurInterface.listeByMairie(id);
//    }

    @GetMapping("/listeUtilisateurById/{id}")
    public ResponseEntity<Object> listeUtilisateurByMairie(@PathVariable(name = "id") Long id)
    {
        boolean isUtilisateurByMairieExist = utilisateurInterface.isUtilisateurByMairieExist(id);
        if (isUtilisateurByMairieExist)
        {
            List<Utilisateur> UtilisateurList = null;
            try {
                UtilisateurList= utilisateurInterface.listeByMairie(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarcherNotFountException();
            }

            return new ResponseEntity<>(UtilisateurList, HttpStatus.OK);
        }
        else
        {
            throw new MarcherNotFountException();
        }

    }



//    @GetMapping("/listeByPlaceUtilisateur/{id}")
//    public List<Object> listeByPlaceUtilisateur(@PathVariable(name = "id") Long id){
//        return utilisateurInterface.findByAffecterPlaceUtilisateur(id);
//    }

    @GetMapping("/listeByPlaceUtilisateur/{id}")
    public ResponseEntity<Object> listeByPlaceUtilisateur(@PathVariable(name = "id") Long id)
    {
        boolean isPlaceUtilisateurExist = utilisateurInterface.isPlaceUtilisateurExist(id);
        if (isPlaceUtilisateurExist)
        {
            List<Object> PlaceByUtilisateurList = null;
            try {
                PlaceByUtilisateurList=utilisateurInterface.findByAffecterPlaceUtilisateur(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PlaceNotFountException();
            }

            return new ResponseEntity<>(PlaceByUtilisateurList, HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }


}




