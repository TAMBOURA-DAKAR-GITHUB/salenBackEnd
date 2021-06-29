package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.AffecterPlaceMarchand;
import com.slaen.salen.entity.Marchand;
import com.slaen.salen.entity.Place;
import com.slaen.salen.repository.*;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AffecterPlaceMarchandImp implements AffecterPlaceMarchandInterface {

    private AffecterPlaceMarchandRepository affecterPlaceMarchandRepository;

    private MarchandRepository marchandRepository;
    private PlaceRepository placeRepository;


    public AffecterPlaceMarchandImp(AffecterPlaceMarchandRepository marchandRepository,
                                    UtilisateurRepository utilisateurRepository, PlaceRepository placeRepository, MarcherRepository marcherRepository, MarchandRepository marchandRepository1, PlaceRepository placeRepository1) {
        this.affecterPlaceMarchandRepository = marchandRepository;
        this.marchandRepository = marchandRepository1;
        this.placeRepository = placeRepository1;
    }

    @Override
    public AffecterPlaceMarchand addAffecterPlaceMarchand(AffecterPlaceMarchand affecterPlaceMarchand) {
        return affecterPlaceMarchandRepository.save(affecterPlaceMarchand);
    }

    @Override
    public List<AffecterPlaceMarchand> listeAffecterPlaceMarchand() {
        return affecterPlaceMarchandRepository.findAll();
    }

    @Override
    public AffecterPlaceMarchand listeById(long id) {
        return affecterPlaceMarchandRepository.findById(id).get();
    }

    @Override
    public AffecterPlaceMarchand UpdateAffecterPlaceMarchand(long id, AffecterPlaceMarchand affecterPlaceMarchand) {
        affecterPlaceMarchand.setIdAffecterPlaceMarchand(id);
        return affecterPlaceMarchandRepository.save(affecterPlaceMarchand);
    }

    @Override
    public void deleteAffecterPlaceMarchand(long id) {
        affecterPlaceMarchandRepository.deleteById(id);
    }

    @Override
    public void AffecterPlaceToMarchand(Marchand marchand, Place place) {

        AffecterPlaceMarchand affecterPlaceMarchand = new AffecterPlaceMarchand();
        //Place place1= placeRepository.findByNumeroPlace(place.getNumeroPlace());
        //Marchand marchand1= marchandRepository.findByNomMarchand(marchand.getNomMarchand());

        affecterPlaceMarchand.setMarchand(marchand);
        affecterPlaceMarchand.setPlace(place);
        affecterPlaceMarchandRepository.save(affecterPlaceMarchand);



    }


}
