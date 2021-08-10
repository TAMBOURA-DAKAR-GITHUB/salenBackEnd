package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Utilisateur;

import java.util.List;

public interface UtilisateurInterface {

    public Utilisateur addUtilisateur(Utilisateur utilisateur);
    public List<Utilisateur> listeUtilisateur();
    public Utilisateur listeById(long id);
    public Utilisateur UpdateUtilisateur(Utilisateur utilisateur);
    public void deleteUtilisateur(long id);

    public List<Utilisateur> listeByMairie(Long idMairie);

    public List<Object> findByAffecterPlaceUtilisateur(Long id);

    // la methode pour verifie si une Utilisateur existe
    public abstract boolean isUtilisateurExist(Long id);
}
