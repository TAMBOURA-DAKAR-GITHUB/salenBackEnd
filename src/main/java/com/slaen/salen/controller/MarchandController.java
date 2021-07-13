package com.slaen.salen.controller;


import com.slaen.salen.entity.Marchand;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.service.Saleninterface.MarchandInterface;
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

    @PostMapping(value = "/addMarhand")
    public Marchand addMarhand(@RequestBody Marchand marchand){
        return marchandInterface.addMarchand(marchand);
    }

    @GetMapping("/listeMarhand")
    public List<Marchand> listeMarhand(){
        return marchandInterface.listeMarchand();
    }

    @GetMapping("/listeById/{id}")
    public  Marchand listeById(@PathVariable(name = "id") Long id){
        return marchandInterface.listeById(id);
    }

    @PutMapping("/updateMarhand/{id}")
    public Marchand updateMarhand(@PathVariable(name = "id") Long id ,@RequestBody Marchand marchand){
        marchand.setIdMarchand(id);
        return marchandInterface.UpdateMarcher(marchand);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        marchandInterface.deleteMarchand(id);
    }

    @GetMapping("/listeMarhandByMarcher/{id}")
    public List<Marchand> listeByMarchand(@PathVariable(name = "id") Long id){
        return marchandInterface.listeByMarcher(id);
    }
}
