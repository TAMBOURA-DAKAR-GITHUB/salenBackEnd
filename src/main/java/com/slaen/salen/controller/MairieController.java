package com.slaen.salen.controller;

import com.slaen.salen.entity.Mairie;
import com.slaen.salen.service.Saleninterface.MairieInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/mairie")
public class MairieController {

    private MairieInterface mairieInterface;

    public MairieController(MairieInterface mairieInterface) {
        this.mairieInterface = mairieInterface;
    }

    @PostMapping(value = "/addMairie")
    public Mairie addMairie(@RequestBody Mairie mairie){
        return mairieInterface.addMairie(mairie);
    }

    @GetMapping("/listeMairie")
    public List<Mairie> listeMairie(){
        return mairieInterface.listeMairie();
    }

    @GetMapping("/listeById/{id}")
    public  Mairie listeById(@PathVariable(name = "id") Long id){
        return mairieInterface.listeById(id);
    }

    @PutMapping("/updateMairie/{id}")
    public Mairie updateMairie(@PathVariable(name = "id") Long id ,@RequestBody Mairie mairie){
        mairie.setIdMairie(id);
        return mairieInterface.UpdateMairie(mairie);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable(name = "id") Long id){
        mairieInterface.deleteMairie(id);
    }

    @ExceptionHandler( Exception.class)
    public ResponseEntity<String>  exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR) ;
    }
}
