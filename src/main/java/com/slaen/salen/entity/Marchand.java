package com.slaen.salen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Marchand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMarchand;
    @Column(length = 50)
    @NotNull
    private String nomMarchand;
    @Column(length = 50)
    @NotNull
    private String prenomMarchand;
    @Temporal(TemporalType.DATE)
    private Date dateOccupationMarchand;
    @Column(length = 50)
    @NotNull
    private String telephoneMarchand;

    @ManyToOne
    @JoinColumn(name = "idMarcher")
    private Marcher marcher;

    @OneToMany(mappedBy = "marchand")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceMarchand> affecterPlaceMarchands;
    @OneToMany(mappedBy = "marchand")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Payement> payements;

    public Marchand() {
    }

    public Marchand(String nomMarchand, String prenomMarchand, String telephoneMarchand, Marcher marcher) {
        this.nomMarchand = nomMarchand;
        this.prenomMarchand = prenomMarchand;
        this.telephoneMarchand = telephoneMarchand;
        this.marcher = marcher;
    }

    public long getIdMarchand() {
        return idMarchand;
    }

    public void setIdMarchand(long idMarchand) {
        this.idMarchand = idMarchand;
    }

    public String getNomMarchand() {
        return nomMarchand;
    }

    public void setNomMarchand(String nomMarchand) {
        this.nomMarchand = nomMarchand;
    }

    public String getPrenomMarchand() {
        return prenomMarchand;
    }

    public void setPrenomMarchand(String prenomMarchand) {
        this.prenomMarchand = prenomMarchand;
    }

    public Date getDateOccupationMarchand() {
        return dateOccupationMarchand;
    }

    public void setDateOccupationMarchand(Date dateOccupationMarchand) {
        this.dateOccupationMarchand = dateOccupationMarchand;
    }

    public String getTelephoneMarchand() {
        return telephoneMarchand;
    }

    public void setTelephoneMarchand(String telephoneMarchand) {
        this.telephoneMarchand = telephoneMarchand;
    }

    public Collection<AffecterPlaceMarchand> getAffecterPlaceMarchands() {
        return affecterPlaceMarchands;
    }

    public void setAffecterPlaceMarchands(Collection<AffecterPlaceMarchand> affecterPlaceMarchands) {
        this.affecterPlaceMarchands = affecterPlaceMarchands;
    }

    public Collection<Payement> getPayements() {
        return payements;
    }

    public void setPayements(Collection<Payement> payements) {
        this.payements = payements;
    }

    public Marcher getMarcher() {
        return marcher;
    }

    public void setMarcher(Marcher marcher) {
        this.marcher = marcher;
    }

    @Override
    public String toString() {
        return "Marchand{" +
                "idMarchand=" + idMarchand +
                ", nomMarchand='" + nomMarchand + '\'' +
                ", prenomMarchand='" + prenomMarchand + '\'' +
                ", dateOccupationMarchand=" + dateOccupationMarchand +
                ", telephoneMarchand='" + telephoneMarchand + '\'' +
                ", marcher=" + marcher +
                ", affecterPlaceMarchands=" + affecterPlaceMarchands +
                ", payements=" + payements +
                '}';
    }
}
