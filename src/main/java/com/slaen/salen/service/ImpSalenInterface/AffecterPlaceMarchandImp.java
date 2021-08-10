package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.AffecterPlaceMarchand;
import com.slaen.salen.model.Marchand;
import com.slaen.salen.model.Place;
import com.slaen.salen.repository.RepositoryData.*;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryAffecterPlaceMarchand;
import com.slaen.salen.service.Saleninterface.AffecterPlaceMarchandInterface;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AffecterPlaceMarchandImp implements AffecterPlaceMarchandInterface {

    private AffecterPlaceMarchandRepository affecterPlaceMarchandRepository;

    private MarchandRepository marchandRepository;
    private PlaceRepository placeRepository;
    private VerificationReposotoryAffecterPlaceMarchand verificationReposotoryAffecterPlaceMarchand;


    public AffecterPlaceMarchandImp(AffecterPlaceMarchandRepository marchandRepository,
                                    UtilisateurRepository utilisateurRepository, PlaceRepository placeRepository, MarcherRepository marcherRepository,
                                    MarchandRepository marchandRepository1, PlaceRepository placeRepository1, VerificationReposotoryAffecterPlaceMarchand verificationReposotoryAffecterPlaceMarchand) {
        this.affecterPlaceMarchandRepository = marchandRepository;
        this.marchandRepository = marchandRepository1;
        this.placeRepository = placeRepository1;
        this.verificationReposotoryAffecterPlaceMarchand = verificationReposotoryAffecterPlaceMarchand;
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
    public void AffecterPlaceToMarchand(long idmarchand, long idplace) {
        AffecterPlaceMarchand affecterPlaceMarchand = new AffecterPlaceMarchand();
       Marchand marchand= marchandRepository.findByIdMarchand(idmarchand);
       Place place= placeRepository.findByIdPlace(idplace);
        place.setSelectedMarchand(true);
        affecterPlaceMarchand.setMarchand(marchand);
        affecterPlaceMarchand.setPlace(place);
        affecterPlaceMarchand.setDateAffecterPlaceMarchand(new Date());
        affecterPlaceMarchandRepository.save(affecterPlaceMarchand);
    }

    @Override
    public boolean isAffecterPlaceMarchandInterfaceExist(Long id) {
        return verificationReposotoryAffecterPlaceMarchand.isAffecterPlaceMarchandInterfaceExist(id);
    }


}
