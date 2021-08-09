package com.slaen.salen.controller;


import com.slaen.salen.model.Marcher;
import com.slaen.salen.service.Saleninterface.MarcherInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/marcher")
public class MarcherController {

    private MarcherInterface marcherInterface;
    public MarcherController(MarcherInterface marcherInterface) {
        this.marcherInterface = marcherInterface;
    }

    @PostMapping(value = "/addMarcher")
    public Marcher addMarcher(@RequestBody Marcher marcher){
        return marcherInterface.addMarcher(marcher);
    }

    @GetMapping("/listeMarcher")
    public List<Marcher> listeMarcher(){
        return marcherInterface.listeMarcher();
    }

    @GetMapping("/listeById/{id}")
    public  Marcher listeById(@PathVariable(name = "id") Long id){
        return marcherInterface.listeById(id);
    }

    @PutMapping("/updateMarhand/{id}")
    public Marcher updateMarcher(@PathVariable(name = "id") Long id ,@RequestBody Marcher marcher){
        marcher.setIdMarcher(id);
        return marcherInterface.UpdateMarcher(marcher);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        marcherInterface.deleteMarcher(id);
    }

    @GetMapping("/listeMarcherById/{id}")
    public List<Marcher> listeByMairie(@PathVariable(name = "id") Long id){
        return marcherInterface.listeByMairie(id);
    }
}
