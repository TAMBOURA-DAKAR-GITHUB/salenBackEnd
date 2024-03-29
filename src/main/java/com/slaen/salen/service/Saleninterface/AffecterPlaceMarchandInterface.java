package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.AffecterPlaceMarchand;

import java.util.List;

public interface AffecterPlaceMarchandInterface {

    public AffecterPlaceMarchand addAffecterPlaceMarchand(AffecterPlaceMarchand affecterPlaceMarchand);
    public List<AffecterPlaceMarchand> listeAffecterPlaceMarchand();
    public AffecterPlaceMarchand listeById(long id);
    public AffecterPlaceMarchand UpdateAffecterPlaceMarchand(long id , AffecterPlaceMarchand affecterPlaceMarchand);
    public void deleteAffecterPlaceMarchand(long id);

    public void AffecterPlaceToMarchand(long idmarchand , long idplace);

    // la methode pour verifie si une affectation existe
    public abstract boolean isAffecterPlaceMarchandInterfaceExist(Long id);


}
