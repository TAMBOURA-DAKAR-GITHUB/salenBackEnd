package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.MarchandNotFountException;
import com.slaen.salen.Exception.InterceptionException.MarcherNotFountException;
import com.slaen.salen.Exception.InterceptionException.PlaceNotFountException;
import com.slaen.salen.model.Place;
import com.slaen.salen.service.Saleninterface.PlaceInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
//
//    @PostMapping(value = "/addPlace")
//    public Place addPalce(@RequestBody Place place){
//        return placeInterface.addPlace(place);
//    }

    @PostMapping(value = "/addPlace")
    public ResponseEntity<Object> addPalce(@RequestBody Place place)
    {
        try {
            place = placeInterface.addPlace(place);

        }catch (Exception e){
            throw new PlaceNotFountException();
        }
        return new ResponseEntity<>(
                "Place "  + place.getNumeroPlace() +" est Creer avec success ",
                HttpStatus.CREATED);

    }


//    @GetMapping("/listePlace")
//    public List<Place> listePalce(){
//        return placeInterface.listePlace();
//    }

    @GetMapping("/listePlace")
    public ResponseEntity<Object> listePalce() {
        List<Place> PlaceList = null;
        try {
            PlaceList = placeInterface.listePlace();
        } catch (Exception e) {
            throw new PlaceNotFountException();
        }

        return new ResponseEntity<>(PlaceList, HttpStatus.OK);
    }


//    @GetMapping("/listeById/{id}")
//    public  Place listeById(@PathVariable(name = "id") Long id){
//        return placeInterface.listeById(id);
//    }

    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isPlaceExist = placeInterface.isPlaceExist(id);
        if (isPlaceExist)
        {
            Place place=null;
            try {
                place = placeInterface.listeById(id);
            }catch (Exception e){
                throw new PlaceNotFountException();
            }

            return new ResponseEntity<>(place, HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }

//    @PutMapping("/updatePlace/{id}")
//    public Place updatePalce(@PathVariable(name = "id") Long id ,@RequestBody Place place){
//        place.setIdPlace(id);
//        return placeInterface.UpdatePlace(place);
//    }

    @PutMapping("/updatePlace/{id}")
    public ResponseEntity<Object> updatePalce(@PathVariable(name = "id") Long id ,@RequestBody Place place)
    {
        boolean isPlaceExist = placeInterface.isPlaceExist(id);
        if (isPlaceExist)
        {

            try {
                place.setIdPlace(id);
                placeInterface.UpdatePlace(place);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PlaceNotFountException();
            }

            return new ResponseEntity<>("Place modifier avec success", HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }

//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        placeInterface.deletePlace(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isPlaceExist = placeInterface.isPlaceExist(id);
        if (isPlaceExist)
        {
            try {
                placeInterface.deletePlace(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PlaceNotFountException();
            }
            return new ResponseEntity<>("Place Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }

//    @GetMapping("/listePlaceByIdMarcher/{id}")
//    public List<Place> listeByMairie(@PathVariable(name = "id") Long id){
//        return placeInterface.listeByPlace(id);
//    }

    @GetMapping("/listePlaceByIdMarcher/{id}")
    public ResponseEntity<Object> listePlaceByMacher(@PathVariable(name = "id") Long id)
    {
        boolean isPlaceByMarcherExist = placeInterface.isPlaceByMarcherExist(id);
        System.out.println(isPlaceByMarcherExist);
        if (isPlaceByMarcherExist)
        {
            List<Place> PlaceList = null;
            try {
                PlaceList= placeInterface.listeByPlace(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarcherNotFountException();
            }

            return new ResponseEntity<>(PlaceList, HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }

}
