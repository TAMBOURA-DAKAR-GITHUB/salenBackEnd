package com.slaen.salen.entity;

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
    private double ResteApaye;

    @ManyToOne
    private Marchand marchand;

    public Payement() {
    }

    public Payement(Date datePayement, double montantPayement, double resteApaye, Marchand marchand) {
        this.datePayement = datePayement;
        this.montantPayement = montantPayement;
        ResteApaye = resteApaye;
        this.marchand = marchand;
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
        return ResteApaye;
    }

    public void setResteApaye(double resteApaye) {
        ResteApaye = resteApaye;
    }

    public Marchand getMarchand() {
        return marchand;
    }

    public void setMarchand(Marchand marchand) {
        this.marchand = marchand;
    }

    @Override
    public String toString() {
        return "Payement{" +
                "idPayement=" + idPayement +
                ", datePayement=" + datePayement +
                ", montantPayement=" + montantPayement +
                ", ResteApaye=" + ResteApaye +
                ", marchand=" + marchand +
                '}';
    }
}
