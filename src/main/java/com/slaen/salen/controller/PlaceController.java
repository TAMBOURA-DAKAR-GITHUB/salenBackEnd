package com.slaen.salen.controller;


import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.service.Saleninterface.PlaceInterface;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/place")
public class PlaceController {

    private PlaceInterface placeInterface;

    public PlaceController(PlaceInterface placeInterface) {
        this.placeInterface = placeInterface;
    }

    @PostMapping(value = "/addPlace")
    public Place addPalce(@RequestBody Place place){
        return placeInterface.addPlace(place);
    }

    @GetMapping("/listePlace")
    public List<Place> listePalce(){
        return placeInterface.listePlace();
    }

    @GetMapping("/listeById/{id}")
    public  Place listeById(@PathVariable(name = "id") Long id){
        return placeInterface.listeById(id);
    }

    @PutMapping("/updatePlace/{id}")
    public Place updatePalce(@PathVariable(name = "id") Long id ,@RequestBody Place place){
        place.setIdPlace(id);
        return placeInterface.UpdatePlace(place);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        placeInterface.deletePlace(id);
    }

    @GetMapping("/listePlaceByIdMarcher/{id}")
    public List<Place> listeByMairie(@PathVariable(name = "id") Long id){
        return placeInterface.listeByPlace(id);
    }
}
