package com.slaen.salen.dto;

import java.util.Date;

public class PlaceMarchandPayement {
    private String utilisateur;
    private String marchand;
    private Date datePayement;
    private double montant;
    private double reste;
    private  int places[] = new int[]{};

    public String getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getMarchand() {
        return marchand;
    }

    public void setMarchand(String marchand) {
        this.marchand = marchand;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public double getReste() {
        return reste;
    }

    public void setReste(double reste) {
        this.reste = reste;
    }

    public int[] getPlaces() {
        return places;
    }

    public void setPlaces(int[] places) {
        this.places = places;
    }
}
