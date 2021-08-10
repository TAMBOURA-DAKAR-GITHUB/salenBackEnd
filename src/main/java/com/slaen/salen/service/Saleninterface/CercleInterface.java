package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Cercle;

import java.util.List;

public interface CercleInterface {

    public Cercle addCercle(Cercle cercle);
    public List<Cercle> listeCercle();
    public Cercle listeById(long id);
    public Cercle UpdateCercle(Cercle cercle);
    public void deleteCercle(long id);

    // la methode pour verifie si une cercle existe
    public abstract boolean isCercleExist(Long id);
}
