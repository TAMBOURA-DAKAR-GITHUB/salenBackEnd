package com.slaen.salen.service.Saleninterface;



import com.slaen.salen.model.Payement;

import java.util.ArrayList;
import java.util.List;

public interface PayementInterface {


    public List<Payement> listePayement();
    public Payement listeById(long id);
    public Payement UpdatePayement(Payement payement);
    public void deletePayement(long id);

    // la gestion des payements

    // la methode pour afficher la liste des marchands
    public ArrayList<Object> ListeMarchandByUtilisateur(Long id);

    // la methodes pour afficher la liste des places par marchand
    public ArrayList<Object> ListePlaceByMarchand(Long id);

    public void addPayement(long idmarchand , long idutilisateur ,  long idplace,  double montant);



}
