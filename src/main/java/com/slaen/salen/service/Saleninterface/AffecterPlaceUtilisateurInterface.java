package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.AffecterPlaceUtilisateur;

import java.util.List;

public interface  AffecterPlaceUtilisateurInterface {

    public AffecterPlaceUtilisateur addAffecterPlaceUtilisateur(AffecterPlaceUtilisateur affecterPlaceUtilisateur);
    public List<AffecterPlaceUtilisateur> listeAffecterPlaceUtilisateur();
    public AffecterPlaceUtilisateur listeById(long id);
    public AffecterPlaceUtilisateur UpdateAffecterPlaceUtilisateur(long id , AffecterPlaceUtilisateur affecterPlaceUtilisateur);
    public void deleteAffecterPlaceUtilisateur(long id);




    public void AffecterPlaceToUtilisateur(long ids , long id);

    // la methode pour verifie si une affectation existe
    public abstract boolean isAffecterPlaceUtilisateurInterfaceExist(Long id);




}
