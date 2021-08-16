package com.slaen.salen.service.ImpSalenInterface;

import com.slaen.salen.model.Utilisateur;
import com.slaen.salen.repository.RepositoryData.UtilisateurRepository;
import com.slaen.salen.repository.RepositoryVerification.VerificationReposotoryUtilisateur;
import com.slaen.salen.service.Saleninterface.UtilisateurInterface;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurImp implements UtilisateurInterface {

    private UtilisateurRepository utilisateurRepository;
    private VerificationReposotoryUtilisateur verificationReposotoryUtilisateur;

    public UtilisateurImp(UtilisateurRepository utilisateurRepository, VerificationReposotoryUtilisateur verificationReposotoryUtilisateur) {
        this.utilisateurRepository = utilisateurRepository;
        this.verificationReposotoryUtilisateur = verificationReposotoryUtilisateur;
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
        return utilisateurRepository.findByAffecterplaceutilisateurUtilisateur(id);
    }

    @Override
    public boolean isUtilisateurExist(Long id) {
        return verificationReposotoryUtilisateur.isUtilisateurExist(id);
    }

    @Override
    public boolean isUtilisateurByMairieExist(Long id) {
        return verificationReposotoryUtilisateur.isUtilisateurByMairieExist(id);
    }

    @Override
    public boolean isPlaceUtilisateurExist(Long id) {
        return verificationReposotoryUtilisateur.isPlaceUtilisateurExist(id);
    }

    @Override
    public Utilisateur VerificationUtilisateur(String telephoneUtilisateur) {
        return utilisateurRepository.findBytelephoneUtilisateur(telephoneUtilisateur);
    }


}
