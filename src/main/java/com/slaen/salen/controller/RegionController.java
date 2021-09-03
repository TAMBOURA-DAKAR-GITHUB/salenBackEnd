package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.RegionExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.RegionNotFountException;
import com.slaen.salen.model.Region;
import com.slaen.salen.service.Saleninterface.RegionInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/api/region")
public class RegionController {

    private RegionInterface regionInterface;
    public RegionController(RegionInterface regionInterface) {
        this.regionInterface = regionInterface;
    }

//    @PostMapping(value = "/addRegion")
//    public Region addRegion(@RequestBody Region region){
//        return regionInterface.addRegion(region);
//    }

    @PostMapping(value = "/addRegion")
    public ResponseEntity<Object> addRegion(@RequestBody Region region)
    {
        String regionexiste= region.getLibelleRegion();
        if(regionexiste != null && !"".equals(regionexiste)){
            Region region1 = regionInterface.VerificationRegion(regionexiste);
            if(region1 != null){
                throw new RegionExistetException();
            }
        }
        try {
            region = regionInterface.addRegion(region);
        }catch (Exception e){
            throw new RegionNotFountException();
        }

        return new ResponseEntity<>(
                region,
                HttpStatus.CREATED);
    }

//    @GetMapping(value = "/listeRegions")
//    public List<Region> listeRegion(){
//        return regionInterface.listeRegions();
//    }

    @GetMapping(value = "/listeRegions")
    public ResponseEntity<Object> listeRegion()
    {
        List<Region> RegionList =null;
        try {
            RegionList = regionInterface.listeRegions();
        }catch (Exception e){
            throw new RegionNotFountException();
        }

        return new ResponseEntity<>(RegionList, HttpStatus.OK);
    }

//    @GetMapping(value = "/listeById/{id}")
//    public Region ListeById(@PathVariable(name = "id") long id){
//      return   regionInterface.RegionById(id);
//    }

    @GetMapping(value = "/listeById/{id}")
    public ResponseEntity<Object> ListeById(@PathVariable(name = "id") long id)
    {
        boolean isRegionExist = regionInterface.isRegionExist(id);
        if (isRegionExist)
        {
            Region region = null;
            try {
                region = regionInterface.RegionById(id);
            }catch (Exception e){
                throw new RegionNotFountException();
            }

            return new ResponseEntity<>(region, HttpStatus.OK);
        }
        else
        {
            throw new RegionNotFountException();
        }

    }

//    @PutMapping(value = "/updateRegion/{id}")
//    public Region updateRegion(@PathVariable(name = "id") Long id, @RequestBody Region region){
//        region.setIdRegion(id);
//        return regionInterface.UpdateRegion(region);
//    }

    @PutMapping(value = "/updateRegion/{id}")
    public ResponseEntity<Object> updateRegion(@PathVariable(name = "id") Long id, @RequestBody Region region)
    {
        boolean isRegionExist = regionInterface.isRegionExist(id);
        if (isRegionExist)
        {
            try {
                 region.setIdRegion(id);
                 regionInterface.UpdateRegion(region);
            }catch (Exception e){
                throw new RegionNotFountException();
            }
            return new ResponseEntity<>(region, HttpStatus.OK);
        }
        else
        {
            throw new RegionNotFountException();
        }

    }

//    @DeleteMapping(value = "deleteById/{id}")
//    public void deleteById( @PathVariable(name = "id") Long id){
//        regionInterface.deleteIdRegionToCercle(id);
//        regionInterface.deleteRegion(id);
//    }


    @DeleteMapping(value = "deleteById/{id}")
    public ResponseEntity<Object> deleteById( @PathVariable(name = "id") Long id)
    {
        boolean isRegionExist = regionInterface.isRegionExist(id);
        if (isRegionExist)
        {
            try {
                regionInterface.deleteRegion(id);
            }catch (Exception e){
                throw  new RegionNotFountException();
            }

            return new ResponseEntity<>("Region Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new RegionNotFountException();
        }

    }



}
