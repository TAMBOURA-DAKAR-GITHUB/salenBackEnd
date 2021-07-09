package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import com.slaen.salen.entity.Place;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.repository.AffecterPlaceUtilisateurRepository;
import com.slaen.salen.repository.PlaceRepository;
import com.slaen.salen.repository.UtilisateurRepository;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AffecterPlaceUtilisateurImp implements AffecterPlaceUtilisateurInterface {

    private AffecterPlaceUtilisateurRepository affecterPlaceUtilisateurRepository;
    private PlaceRepository placeRepository;
    private UtilisateurRepository utilisateurRepository;

    public AffecterPlaceUtilisateurImp(AffecterPlaceUtilisateurRepository affecterPlaceUtilisateurRepository,
                                       PlaceRepository placeRepository, UtilisateurRepository utilisateurRepository) {
        this.affecterPlaceUtilisateurRepository = affecterPlaceUtilisateurRepository;
        this.placeRepository = placeRepository;
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public AffecterPlaceUtilisateur addAffecterPlaceUtilisateur(AffecterPlaceUtilisateur affecterPlaceUtilisateur) {
        return affecterPlaceUtilisateurRepository.save(affecterPlaceUtilisateur);
    }

    @Override
    public List<AffecterPlaceUtilisateur> listeAffecterPlaceUtilisateur() {
        return affecterPlaceUtilisateurRepository.findAll(Sort.by("dateAffecterPlaceUtilisateur").descending());
    }

    @Override
    public AffecterPlaceUtilisateur listeById(long id) {
        return affecterPlaceUtilisateurRepository.findById(id).get();
    }

    @Override
    public AffecterPlaceUtilisateur UpdateAffecterPlaceUtilisateur(long id, AffecterPlaceUtilisateur affecterPlaceUtilisateur) {
        affecterPlaceUtilisateur.setIdAffecterPlaceUtilisateur(id);
        return affecterPlaceUtilisateurRepository.save(affecterPlaceUtilisateur);
    }

    @Override
    public void deleteAffecterPlaceUtilisateur(long id) {
        affecterPlaceUtilisateurRepository.deleteById(id);
    }

    @Override
    public void AffecterPlaceToUtilisateur(long ids , long id) {
        AffecterPlaceUtilisateur affecterPlaceUtilisateur = new AffecterPlaceUtilisateur();
        Utilisateur u = utilisateurRepository.findByIdUtilisateur(ids);
         Place p= placeRepository.findByIdPlace(id);
         p.setSelected(true);
        affecterPlaceUtilisateur.setUtilisateur(u);
        affecterPlaceUtilisateur.setPlace(p);
        affecterPlaceUtilisateur.setDateAffecterPlaceUtilisateur(new Date());

        // et sauvegarder les donnees .
        affecterPlaceUtilisateurRepository.save(affecterPlaceUtilisateur);








        }

}
