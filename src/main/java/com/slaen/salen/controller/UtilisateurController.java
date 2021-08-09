package com.slaen.salen.controller;



import com.slaen.salen.model.Utilisateur;
import com.slaen.salen.service.Saleninterface.UtilisateurInterface;
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

    @GetMapping(value = "/listeUtilisateur")
    public List<Utilisateur> listeUtilisateur(){
        return utilisateurInterface.listeUtilisateur();
    }

    @PostMapping(value = "/addUtilisateur")
    public Utilisateur addUtilisateur(@RequestBody Utilisateur utilisateur){
        return utilisateurInterface.addUtilisateur(utilisateur);
    }

    @GetMapping(value = "/listeById/{id}")
    public Utilisateur ListeById(@PathVariable(name = "id") long id){
        return   utilisateurInterface.listeById(id);
    }

    @PutMapping(value = "/updateUtilisateur/{id}")
    public Utilisateur updateUtilisateur(@PathVariable(name = "id") Long id, @RequestBody Utilisateur utilisateur){
        utilisateur.setIdUtilisateur(id);
        return utilisateurInterface.UpdateUtilisateur(utilisateur);
    }

    @DeleteMapping(value = "deleteById/{id}")
    public void deleteById( @PathVariable(name = "id") Long id){
        utilisateurInterface.deleteUtilisateur(id);
    }

    @GetMapping("/listeUtilisateurById/{id}")
    public List<Utilisateur> listeByMairie(@PathVariable(name = "id") Long id){
        return utilisateurInterface.listeByMairie(id);
    }


   @GetMapping("/listeByPlaceUtilisateur/{id}")
    public List<Object> listeByPlaceUtilisateur(@PathVariable(name = "id") Long id){
        return utilisateurInterface.findByAffecterPlaceUtilisateur(id);
    }


}




