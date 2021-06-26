package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import com.slaen.salen.repository.AffecterPlaceUtilisateurRepository;
import com.slaen.salen.service.Saleninterface.AffecterPlaceUtilisateurInterface;

import java.util.List;

public class AffecterPlaceUtilisateurImp implements AffecterPlaceUtilisateurInterface {

    private AffecterPlaceUtilisateurRepository affecterPlaceUtilisateurRepository;

    public AffecterPlaceUtilisateurImp(AffecterPlaceUtilisateurRepository affecterPlaceUtilisateurRepository) {
        this.affecterPlaceUtilisateurRepository = affecterPlaceUtilisateurRepository;
    }

    @Override
    public AffecterPlaceUtilisateur addAffecterPlaceUtilisateur(AffecterPlaceUtilisateur affecterPlaceUtilisateur) {
        return affecterPlaceUtilisateurRepository.save(affecterPlaceUtilisateur);
    }

    @Override
    public List<AffecterPlaceUtilisateur> listeAffecterPlaceUtilisateur() {
        return affecterPlaceUtilisateurRepository.findAll();
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
}
