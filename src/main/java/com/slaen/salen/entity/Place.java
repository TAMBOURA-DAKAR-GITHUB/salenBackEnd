package com.slaen.salen.entity;

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

    @ManyToOne
    private Marcher marcher;
    @OneToMany(mappedBy = "place")

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs;
    @OneToMany(mappedBy = "place")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceMarchand> affecterPlaceMarchands;


    public Place() {
    }

    public Place(String numeroPlace, Marcher marcher) {
        this.numeroPlace = numeroPlace;
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

    @Override
    public String toString() {
        return "Place{" +
                "idPlace=" + idPlace +
                ", numeroPlace='" + numeroPlace + '\'' +
                ", marcher=" + marcher +
                ", affecterPlaceUtilisateurs=" + affecterPlaceUtilisateurs +
                ", affecterPlaceMarchands=" + affecterPlaceMarchands +
                '}';
    }
}
