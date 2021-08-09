package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Marchand;

import java.util.List;

public interface MarchandInterface {

    public Marchand addMarchand(Marchand marchand);
    public List<Marchand> listeMarchand();
    public Marchand listeById(long id);
    public Marchand UpdateMarcher(Marchand marchand);
    public void deleteMarchand(long id);

    public List<Marchand> listeByMarcher(Long id);
}
