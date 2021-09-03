package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.AffecterPlaceMarchandNotFountException;
import com.slaen.salen.dto.TestPlaceToMarchand;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/placeToMarchand")
public class AffecterPlaceMarchandController {

    private AffecterPlaceMarchandInterface affecterPlaceMarchandInterface;
    public AffecterPlaceMarchandController(AffecterPlaceMarchandInterface affecterPlaceMarchandInterface) {
        this.affecterPlaceMarchandInterface = affecterPlaceMarchandInterface;
    }

//    @PostMapping("/placeToMarchand")
//    public void PlaceToMarchand(@RequestBody TestPlaceToMarchand testPlaceToMarchand){
//
//        long idmarchand= (long)  Integer.parseInt(testPlaceToMarchand.getMarchand());
//        for (long i : testPlaceToMarchand.getPlaces()) {
//            affecterPlaceMarchandInterface.AffecterPlaceToMarchand(idmarchand , i);
//        }
//
//    }

    @PostMapping("/placeToMarchand")
    public ResponseEntity<Object> PlaceToMarchand(@RequestBody TestPlaceToMarchand testPlaceToMarchand)
    {
        try {
            long idmarchand= (long)  Integer.parseInt(testPlaceToMarchand.getMarchand());
            for (long i : testPlaceToMarchand.getPlaces()) {
                affecterPlaceMarchandInterface.AffecterPlaceToMarchand(idmarchand , i);
            }
        }catch (Exception e){
            throw new AffecterPlaceMarchandNotFountException();
        }
        return new ResponseEntity<>(
                testPlaceToMarchand,
                HttpStatus.CREATED);

    }
}
