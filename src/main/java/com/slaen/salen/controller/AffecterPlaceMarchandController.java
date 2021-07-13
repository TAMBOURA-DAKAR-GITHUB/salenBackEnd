package com.slaen.salen.controller;


import com.slaen.salen.entity.TestPlaceToMarchand;
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
    public void PlaceToMarchand(@RequestBody TestPlaceToMarchand testPlaceToMarchand){

        long idmarchand= (long)  Integer.parseInt(testPlaceToMarchand.getMarchand());
        for (long i : testPlaceToMarchand.getPlaces()) {
            affecterPlaceMarchandInterface.AffecterPlaceToMarchand(idmarchand , i);
        }

    }
}
