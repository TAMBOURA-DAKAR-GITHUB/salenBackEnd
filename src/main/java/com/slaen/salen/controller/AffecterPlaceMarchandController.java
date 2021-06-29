package com.slaen.salen.controller;


import com.slaen.salen.entity.Marchand;
import com.slaen.salen.entity.Place;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/placeToMarchand")
public class AffecterPlaceMarchandController {

    private AffecterPlaceMarchandInterface affecterPlaceMarchandInterface;
    public AffecterPlaceMarchandController(AffecterPlaceMarchandInterface affecterPlaceMarchandInterface) {
        this.affecterPlaceMarchandInterface = affecterPlaceMarchandInterface;
    }

    @PostMapping("/placeToMarchand")
    public void PlaceToMarchand(@RequestBody Place place , @RequestBody Marchand marchand){
        affecterPlaceMarchandInterface.AffecterPlaceToMarchand(marchand ,place );
    }
}
