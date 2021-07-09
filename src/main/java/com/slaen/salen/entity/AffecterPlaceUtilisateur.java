package com.slaen.salen.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AffecterPlaceUtilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAffecterPlaceUtilisateur;
    @Temporal(TemporalType.DATE)
    private Date dateAffecterPlaceUtilisateur;

    @ManyToOne
    @JoinColumn(name = "idPlace")
    private Place place;
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    public AffecterPlaceUtilisateur() {
    }

    public AffecterPlaceUtilisateur(Place place, Utilisateur utilisateur) {
        this.place = place;
        this.utilisateur = utilisateur;
        this.dateAffecterPlaceUtilisateur= new Date();
    }

    public long getIdAffecterPlaceUtilisateur() {
        return idAffecterPlaceUtilisateur;
    }

    public void setIdAffecterPlaceUtilisateur(long idAffecterPlaceUtilisateur) {
        this.idAffecterPlaceUtilisateur = idAffecterPlaceUtilisateur;
    }

    public Date getDateAffecterPlaceUtilisateur() {
        return dateAffecterPlaceUtilisateur;
    }

    public void setDateAffecterPlaceUtilisateur(Date dateAffecterPlaceUtilisateur) {
        this.dateAffecterPlaceUtilisateur = dateAffecterPlaceUtilisateur;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    @Override
    public String toString() {
        return "AffecterPlaceUtilisateur{" +
                "idAffecterPlaceUtilisateur=" + idAffecterPlaceUtilisateur +
                ", dateAffecterPlaceUtilisateur=" + dateAffecterPlaceUtilisateur +
                ", place=" + place +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
