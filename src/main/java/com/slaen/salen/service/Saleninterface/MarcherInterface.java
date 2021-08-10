package com.slaen.salen.service.Saleninterface;

import com.slaen.salen.model.Marcher;

import java.util.List;

public interface MarcherInterface {

    public Marcher addMarcher(Marcher marcher);
    public List<Marcher> listeMarcher();
    public Marcher listeById(long id);
    public Marcher UpdateMarcher(Marcher marcher);
    public void deleteMarcher(long id);

    public List<Marcher> listeByMairie(Long idMairie);

    // la methode pour verifie si une Marcher existe
    public abstract boolean isMarcherExist(Long id);
    // la methode pour verifier s'il des marcher dans la mairie
    public abstract boolean isMarcherByMairieExist(Long id);


}
