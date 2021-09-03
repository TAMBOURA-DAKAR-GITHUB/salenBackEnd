package com.slaen.salen.controller;

import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionExistance.MairieExistetException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MairieNotFountException;
import com.slaen.salen.model.Mairie;
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

//    @PostMapping(value = "/addMairie")
//    public Mairie addMairie(@RequestBody Mairie mairie){
//        return mairieInterface.addMairie(mairie);
//    }

    @PostMapping(value = "/addMairie")
    public ResponseEntity<Object> addMairie(@RequestBody Mairie mairie)  {
        String mairieexiste = mairie.getLibelleMairie();
        if(mairieexiste != null && !"".equals(mairieexiste)){
            Mairie mairie1= mairieInterface.VerificationMairie(mairieexiste);
                if(mairie1 != null){
                    throw new MairieExistetException();
                }
        }
        try {
            mairie = mairieInterface.addMairie(mairie);
        }catch (Exception e){
            throw new MairieNotFountException();
        }
        return new ResponseEntity<>(
                mairie,
                HttpStatus.CREATED);
    }



//    @GetMapping("/listeMairie")
//    public List<Mairie> listeMairie(){
//        return mairieInterface.listeMairie();
//    }

    @GetMapping("/listeMairie")
    public ResponseEntity<Object> listeMairie()
    {
        List<Mairie> MairieList =null;
        try {
             MairieList = mairieInterface.listeMairie();
        }catch (Exception e){
            throw new MairieNotFountException();
        }

        return new ResponseEntity<>(MairieList, HttpStatus.OK);
    }



//    @GetMapping("/listeById/{id}")
//    public  Mairie listeById(@PathVariable(name = "id") Long id){
//        return mairieInterface.listeById(id);
//    }


    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable("id") Long id)
    {
        boolean isMairieExist = mairieInterface.isMairieExist(id);
        if (isMairieExist)
        {
            Mairie mairie =null;
            try {
                 mairie =mairieInterface.listeById(id);
            }catch (Exception e){
                throw new MairieNotFountException();
            }
            return new ResponseEntity<>(mairie, HttpStatus.OK);
        }
        else
        {
            throw new MairieNotFountException();
        }

    }

//    @PutMapping("/updateMairie/{id}")
//    public Mairie updateMairie(@PathVariable(name = "id") Long id ,@RequestBody Mairie mairie){
//        mairie.setIdMairie(id);
//        return mairieInterface.UpdateMairie(mairie);
//    }

    @PutMapping("/updateMairie/{id}")
    public ResponseEntity<Object> updateMairie(@PathVariable("id") Long id,
                                                 @RequestBody Mairie mairie)
    {
        boolean isMairieExist = mairieInterface.isMairieExist(id);
        if (isMairieExist)
        {
            try {
                mairie.setIdMairie(id);
                mairieInterface.UpdateMairie(mairie);
            }catch (Exception e){
                throw new MairieNotFountException();
            }

            return new ResponseEntity<>(mairie, HttpStatus.OK);
        }
        else
        {
            throw new MairieNotFountException();
        }

    }



//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        mairieInterface.deleteMairie(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") Long id)
    {
        boolean isMairieExist = mairieInterface.isMairieExist(id);
        if (isMairieExist)
        {
            try {
                mairieInterface.deleteMairie(id);
            }catch (Exception e){
                throw new MairieNotFountException();
            }

            return new ResponseEntity<>("Mairie Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new MairieNotFountException();
        }

    }

//    @ExceptionHandler( Exception.class)
//    public ResponseEntity<String>  exceptionHandler(Exception e){
//        return new ResponseEntity<>(e.getMessage() , HttpStatus.INTERNAL_SERVER_ERROR) ;
//    }
}
