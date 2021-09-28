package com.slaen.salen.controller;



import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MarchandNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MarcherNotFountException;
import com.slaen.salen.model.Marcher;
import com.slaen.salen.service.Saleninterface.MarcherInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

//    @PostMapping(value = "/addMarcher")
//    public Marcher addMarcher(@RequestBody Marcher marcher){
//        return marcherInterface.addMarcher(marcher);
//    }

    @PostMapping(value = "/addMarcher")
    public ResponseEntity<Object> addMarcher(@RequestBody Marcher marcher)
    {
        try {
            marcher = marcherInterface.addMarcher(marcher);

        }catch (Exception e){
            throw new MarcherNotFountException();
        }
        return new ResponseEntity<>(
                marcher,
                HttpStatus.CREATED);

    }

//    @GetMapping("/listeMarcher")
//    public List<Marcher> listeMarcher(){
//        return marcherInterface.listeMarcher();
//    }

    @GetMapping("/listeMarcher")
    public ResponseEntity<Object> listeMarcher() {
        List<Marcher> MarcherList = null;
        try {
            MarcherList = marcherInterface.listeMarcher();
        } catch (Exception e) {
            throw new MarcherNotFountException();
        }

        return new ResponseEntity<>(MarcherList, HttpStatus.OK);
    }



//    @GetMapping("/listeById/{id}")
//    public  Marcher listeById(@PathVariable(name = "id") Long id){
//        return marcherInterface.listeById(id);
//    }

    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isMarcherExist = marcherInterface.isMarcherExist(id);
        if (isMarcherExist)
        {
            Marcher marcher=null;
            try {
                 marcher = marcherInterface.listeById(id);
            }catch (Exception e){
                throw new MarcherNotFountException();
            }

            return new ResponseEntity<>(marcher, HttpStatus.OK);
        }
        else
        {
            throw new MarcherNotFountException();
        }

    }

//    @PutMapping("/updateMarhand/{id}")
//    public Marcher updateMarcher(@PathVariable(name = "id") Long id ,@RequestBody Marcher marcher){
//        marcher.setIdMarcher(id);
//        return marcherInterface.UpdateMarcher(marcher);
//    }


    @PutMapping("/updateMarher/{id}")
    public ResponseEntity<Object> updateMarcher(@PathVariable(name = "id") Long id ,@RequestBody Marcher marcher)
    {
        boolean isMarcherExist = marcherInterface.isMarcherExist(id);
        if (isMarcherExist)
        {

            try {
                marcher.setIdMarcher(id);
                marcherInterface.UpdateMarcher(marcher);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarcherNotFountException();
            }

            return new ResponseEntity<>(marcher, HttpStatus.OK);
        }
        else
        {
            throw new MarcherNotFountException();
        }

    }

//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id){
//        marcherInterface.deleteMarcher(id);
//    }


    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isMarcherExist = marcherInterface.isMarcherExist(id);
        if (isMarcherExist)
        {
            try {
                marcherInterface.deleteMarcher(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarcherNotFountException();
            }
            return new ResponseEntity<>("Marcher Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new MarcherNotFountException();
        }

    }

//    @GetMapping("/listeMarcherById/{id}")
//    public List<Marcher> listeByMairie(@PathVariable(name = "id") Long id){
//        return marcherInterface.listeByMairie(id);
//    }

    @GetMapping("/listeMarcherById/{id}")
    public ResponseEntity<Object> listeByMairie(@PathVariable(name = "id") Long id)
    {
        boolean isMarcherByMairieExist = marcherInterface.isMarcherByMairieExist(id);
        if (isMarcherByMairieExist)
        {
            List<Marcher> MarcherList = null;
            try {
                MarcherList= marcherInterface.listeByMairie(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarcherNotFountException();
            }

            return new ResponseEntity<>(MarcherList, HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }


}
