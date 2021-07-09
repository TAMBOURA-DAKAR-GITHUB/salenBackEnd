package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.entity.AffecterPlaceUtilisateur;
import com.slaen.salen.entity.Utilisateur;
import com.slaen.salen.repository.UtilisateurRepository;
import com.slaen.salen.service.Saleninterface.UtilisateurInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurImp implements UtilisateurInterface {

    private UtilisateurRepository utilisateurRepository;

    public UtilisateurImp(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    @Override
    public Utilisateur addUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public List<Utilisateur> listeUtilisateur() {
        return utilisateurRepository.findAll();
    }

    @Override
    public Utilisateur listeById(long id) {
        return utilisateurRepository.findById(id).get();
    }

    @Override
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    @Override
    public void deleteUtilisateur(long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<Utilisateur> listeByMairie(Long idMairie) {
        return utilisateurRepository.findByMairieIdMairie(idMairie);
    }

   @Override
    public List<Object> findByAffecterPlaceUtilisateur(Long id) {
        return utilisateurRepository.findByAffecterplaceutilisateurUtilisateurr(id);
    }


}
