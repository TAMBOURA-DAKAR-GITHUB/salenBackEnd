package com.slaen.salen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Place implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPlace;
    @Column(length = 50)
    @NotNull
    private String numeroPlace;
    @NotNull
    private  boolean selectedUtilisateur;
    @NotNull
    private  boolean selectedMarchand;

    @ManyToOne
    @JoinColumn(name = "idMarcher")
    private Marcher marcher;
    @OneToMany(mappedBy = "place")

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs;
    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceMarchand> affecterPlaceMarchands;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "place")
    private Collection<Payement> payements;


    public Place() {
    }

    public Place(String numeroPlace,  Marcher marcher) {
        this.numeroPlace = numeroPlace;
       // this.selected = false;
        this.marcher = marcher;
    }

    public long getIdPlace() {
        return idPlace;
    }

    public void setIdPlace(long idPlace) {
        this.idPlace = idPlace;
    }

    public String getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(String numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public Marcher getMarcher() {
        return marcher;
    }

    public void setMarcher(Marcher marcher) {
        this.marcher = marcher;
    }

    public boolean isSelectedUtilisateur() {
        return selectedUtilisateur;
    }

    public void setSelectedUtilisateur(boolean selectedUtilisateur) {
        this.selectedUtilisateur = selectedUtilisateur;
    }

    public boolean isSelectedMarchand() {
        return selectedMarchand;
    }

    public void setSelectedMarchand(boolean selectedMarchand) {
        this.selectedMarchand = selectedMarchand;
    }

    public Collection<AffecterPlaceUtilisateur> getAffecterPlaceUtilisateurs() {
        return affecterPlaceUtilisateurs;
    }

    public void setAffecterPlaceUtilisateurs(Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs) {
        this.affecterPlaceUtilisateurs = affecterPlaceUtilisateurs;
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

    @Override
    public String toString() {
        return "Place{" +
                "idPlace=" + idPlace +
                ", numeroPlace='" + numeroPlace + '\'' +
                ", selectedUtilisateur=" + selectedUtilisateur +
                ", selectedMarchand=" + selectedMarchand +
                ", marcher=" + marcher +
                ", affecterPlaceUtilisateurs=" + affecterPlaceUtilisateurs +
                ", affecterPlaceMarchands=" + affecterPlaceMarchands +
                ", payements=" + payements +
                '}';
    }
}
