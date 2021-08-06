package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.Marchand;
import com.slaen.salen.entity.Payement;
import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.repository.MarchandRepository;
import com.slaen.salen.repository.PayementRepository;
import com.slaen.salen.repository.PlaceRepository;
import com.slaen.salen.repository.UtilisateurRepository;
import com.slaen.salen.service.Saleninterface.PayementInterface;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PayementImp implements PayementInterface {

    private PayementRepository payementRepository;
    private UtilisateurRepository utilisateurRepository;
    private PlaceRepository placeRepository;
    private MarchandRepository marchandRepository;

    public PayementImp(PayementRepository payementRepository, UtilisateurRepository utilisateurRepository, PlaceRepository placeRepository, MarchandRepository marchandRepository) {
        this.payementRepository = payementRepository;
        this.utilisateurRepository = utilisateurRepository;
        this.placeRepository = placeRepository;
        this.marchandRepository = marchandRepository;
    }


    @Override
    public List<Payement> listePayement() {
        return payementRepository.findAll();
    }

    @Override
    public Payement listeById(long id) {
        return payementRepository.findById(id).get();
    }

    @Override
    public Payement UpdatePayement(Payement payement) {
        return payementRepository.save(payement);
    }

    @Override
    public void deletePayement(long id) {
        payementRepository.deleteById(id);

    }

    @Override
    public ArrayList<Object> ListeMarchandByUtilisateur(Long id) {
        return payementRepository.findByMarchandByUtilisateur(id);
    }

    @Override
    public ArrayList<Object> ListePlaceByMarchand(Long id) {
        return payementRepository.findByPlaceByMarchand(id);
    }

    @Override
    public void addPayement(long idmarchand , long idutilisateur ,  long idplace,  double montant) {

        Payement payement = new Payement();
        Utilisateur utilisateur = utilisateurRepository.findByIdUtilisateur(idutilisateur);
        Place place= placeRepository.findByIdPlace(idplace);
        Marchand marchand= marchandRepository.findByIdMarchand(idmarchand);
        payement.setMarchand(marchand);
        payement.setPlace(place);
        payement.setUtilisateur(utilisateur);
        payement.setDatePayement(new Date());
        payement.setMontantPayement(montant);
        payementRepository.save(payement) ;
    }


}
