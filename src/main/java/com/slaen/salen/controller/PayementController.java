package com.slaen.salen.controller;


import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.MarchandNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.PayementNotFountException;
import com.slaen.salen.Exception.InterceptionException.InterceptionExceptionSimple.PlaceNotFountException;
import com.slaen.salen.model.Payement;
import com.slaen.salen.dto.PlaceMarchandPayement;
import com.slaen.salen.service.Saleninterface.PayementInterface;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/payement")
public class PayementController {

    private PayementInterface payementInterface;

    public PayementController(PayementInterface payementInterface) {
        this.payementInterface = payementInterface;
    }


//    @GetMapping("/listePayement")
//    public List<Payement> listePayement() {
//        return payementInterface.listePayement();
//    }


    @GetMapping("/listePayement")
    public ResponseEntity<Object> listePayement() {
        List<Payement> PayementList = null;
        try {
            PayementList = payementInterface.listePayement();
        } catch (Exception e) {
            throw new PayementNotFountException();
        }

        return new ResponseEntity<>(PayementList, HttpStatus.OK);
    }

//    @GetMapping("/listeById/{id}")
//    public Payement listeById(@PathVariable(name = "id") Long id) {
//        return payementInterface.listeById(id);
//    }

    @GetMapping("/listeById/{id}")
    public ResponseEntity<Object> listeById(@PathVariable(name = "id") Long id)
    {
        boolean isPayementExist = payementInterface.isPayementExist(id);
        if (isPayementExist)
        {
            Payement payement=null;
            try {
                payement = payementInterface.listeById(id);
            }catch (Exception e){
                throw new PayementNotFountException();
            }

            return new ResponseEntity<>(payement, HttpStatus.OK);
        }
        else
        {
            throw new PayementNotFountException();
        }

    }

//    @PutMapping("/updatePayement/{id}")
//    public Payement updatePayement(@PathVariable(name = "id") Long id, @RequestBody Payement payement) {
//        payement.setIdPayement(id);
//        return payementInterface.UpdatePayement(payement);
//    }

    @PutMapping("/updatePayement/{id}")
    public ResponseEntity<Object> updatePayement(@PathVariable(name = "id") Long id, @RequestBody Payement payement)
    {
        boolean isPayementExist = payementInterface.isPayementExist(id);
        if (isPayementExist)
        {

            try {
                payement.setIdPayement(id);
                payementInterface.UpdatePayement(payement);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PayementNotFountException();
            }

            return new ResponseEntity<>(payement, HttpStatus.OK);
        }
        else
        {
            throw new PayementNotFountException();
        }

    }

//    @DeleteMapping("/deleteById/{id}")
//    public void deleteById(@PathVariable(name = "id") Long id) {
//        payementInterface.deletePayement(id);
//    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable(name = "id") Long id)
    {
        boolean isPayementExist = payementInterface.isPayementExist(id);
        if (isPayementExist)
        {
            try {
                payementInterface.deletePayement(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PayementNotFountException();
            }
            return new ResponseEntity<>("Payement Supprimer avec success", HttpStatus.OK);
        }
        else
        {
            throw new PayementNotFountException();
        }

    }

//    @GetMapping("/listeMarchandByUtilisateur/{id}")
//    public ArrayList<Object> listeMarchandByUtilisateur(@PathVariable(name = "id") Long id) {
//        return payementInterface.ListeMarchandByUtilisateur(id);
//    }

    @GetMapping("/listeMarchandByUtilisateur/{id}")
    public ResponseEntity<Object> listeMarchandByUtilisateur(@PathVariable(name = "id") Long id)
    {
        boolean isMarchandByUtilisateurExist = payementInterface.isMarchandByUtilisateurExist(id);
        System.out.println(isMarchandByUtilisateurExist);
        if (isMarchandByUtilisateurExist)
        {
            List<Object> listeMarchandByUtilisateur = null;
            try {
                listeMarchandByUtilisateur= payementInterface.ListeMarchandByUtilisateur(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new MarchandNotFountException();
            }

            return new ResponseEntity<>(listeMarchandByUtilisateur, HttpStatus.OK);
        }
        else
        {
            throw new MarchandNotFountException();
        }

    }

//    @GetMapping("/listePlaceByMarchand/{id}")
//    public ArrayList<Object> listePlaceByMarchand(@PathVariable(name = "id") Long id) {
//        return payementInterface.ListePlaceByMarchand(id);
//    }

    @GetMapping("/listePlaceByMarchand/{id}")
    public ResponseEntity<Object> listePlaceByMarchand(@PathVariable(name = "id") Long id)
    {
        boolean isPlaceByMarchandExist = payementInterface.isPlaceByMarchandExist(id);
        //System.out.println(isPlaceByMarcherExist);
        if (isPlaceByMarchandExist)
        {
            List<Object> listePlaceByMarchand = null;
            try {
                listePlaceByMarchand= payementInterface.ListePlaceByMarchand(id);
            }catch (Exception e){
                // creer une autre exception pour dire que la modification a echoue
                throw new PlaceNotFountException();
            }

            return new ResponseEntity<>(listePlaceByMarchand, HttpStatus.OK);
        }
        else
        {
            throw new PlaceNotFountException();
        }

    }

//    @PostMapping(value = "/addPayement")
//    public void addPayement(@RequestBody PlaceMarchandPayement placeMarchandPayement) {
//        long idutilisateur = (long) Integer.parseInt(placeMarchandPayement.getUtilisateur());
//        long idmarchand = (long) Integer.parseInt(placeMarchandPayement.getMarchand());
//        double montant = placeMarchandPayement.getMontant();
//
//        for (long place : placeMarchandPayement.getPlaces()) {
//                payementInterface.addPayement(idutilisateur,idmarchand,place,montant);
//            }
//
//        }


    @PostMapping(value = "/addPayement")
    public ResponseEntity<Object> addPayement(@RequestBody PlaceMarchandPayement placeMarchandPayement)
    {
        try {
            long idutilisateur = (long) Integer.parseInt(placeMarchandPayement.getUtilisateur());
            long idmarchand = (long) Integer.parseInt(placeMarchandPayement.getMarchand());
            double montant = placeMarchandPayement.getMontant();

            for (long place : placeMarchandPayement.getPlaces()) {
               payementInterface.addPayement(idutilisateur,idmarchand,place,montant);
            }

        }catch (Exception e){
            throw new PayementNotFountException();
        }
        return new ResponseEntity<>(
                placeMarchandPayement,
                HttpStatus.CREATED);

    }

}
