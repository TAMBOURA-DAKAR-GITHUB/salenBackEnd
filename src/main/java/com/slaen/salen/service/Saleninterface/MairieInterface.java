package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Mairie;

import java.util.List;

public interface MairieInterface {

    public Mairie addMairie(Mairie mairie);
    public List<Mairie> listeMairie();
    public Mairie listeById(long id);
    public Mairie UpdateMairie( Mairie mairie);
    public void deleteMairie(long id);
    public abstract boolean isMairieExist(Long id);
    public Mairie VerificationMairie(String libelleMairie);
}
