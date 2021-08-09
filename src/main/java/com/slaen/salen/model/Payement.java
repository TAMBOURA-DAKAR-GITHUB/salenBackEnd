package com.slaen.salen.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPayement;
    @Temporal(TemporalType.DATE)
    private Date datePayement;
    @NotNull
    private double montantPayement;
    @NotNull
    private double resteApaye;

    @ManyToOne
    @JoinColumn(name = "idMarchand")
    private Marchand marchand;
    @ManyToOne
    @JoinColumn(name = "idPlace")
    private Place place;
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;

    public Payement() {
    }

    public Payement(Date datePayement, double montantPayement, double resteApaye, Marchand marchand , Place place , Utilisateur utilisateur) {
        this.datePayement = datePayement;
        this.montantPayement = montantPayement;
        this.resteApaye = resteApaye;
        this.marchand = marchand;
        this.place=place;
        this.utilisateur=utilisateur;

        /* les information sur le marchand est recupere l'orsqu'on appui sur la liste des marchands
        idm pour les places. Ensuite le champs payement est afficher pour faire le payement
         */
    }

    public long getIdPayement() {
        return idPayement;
    }

    public void setIdPayement(long idPayement) {
        this.idPayement = idPayement;
    }

    public Date getDatePayement() {
        return datePayement;
    }

    public void setDatePayement(Date datePayement) {
        this.datePayement = datePayement;
    }

    public double getMontantPayement() {
        return montantPayement;
    }

    public void setMontantPayement(double montantPayement) {
        this.montantPayement = montantPayement;
    }

    public double getResteApaye() {
        return resteApaye;
    }

    public void setResteApaye(double resteApaye) {
        this.resteApaye = resteApaye;
    }

    public Marchand getMarchand() {
        return marchand;
    }

    public void setMarchand(Marchand marchand) {
        this.marchand = marchand;
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
        return "Payement{" +
                "idPayement=" + idPayement +
                ", datePayement=" + datePayement +
                ", montantPayement=" + montantPayement +
                ", resteApaye=" + resteApaye +
                ", marchand=" + marchand +
                ", place=" + place +
                ", utilisateur=" + utilisateur +
                '}';
    }
}
