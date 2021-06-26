package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.entity.Utilisateur;

import java.util.List;

public interface UtilisateurInterface {

    public Utilisateur addUtilisateur(Utilisateur utilisateur);
    public List<Utilisateur> listeUtilisateur();
    public Utilisateur listeById(long id);
    public Utilisateur UpdateUtilisateur(long id , Utilisateur utilisateur);
    public void deleteUtilisateur(long id);
}
