package com.slaen.salen.model;

import com.fasterxml.jackson.annotation.JsonProperty;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Mairie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMairie;
    @Column(length = 50)
    @NotNull
    private String libelleMairie;
    @Column(length = 50)
    @NotNull
    private String quartierMairie;
    @NotNull
    private String typeMairie;

    @ManyToOne
    private Commune commune;

    @OneToMany(mappedBy = "mairie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Marcher> marchers;

    @OneToMany(mappedBy = "mairie")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Utilisateur> utilisateurs;

    public Mairie() {

    }

    public Mairie(String libelleMairie, String quartierMairie, String typeMairie, Commune commune) {
        this.libelleMairie = libelleMairie;
        this.quartierMairie = quartierMairie;
        this.typeMairie = typeMairie;
        this.commune = commune;
    }

    public long getIdMairie() {
        return idMairie;
    }

    public void setIdMairie(long idMairie) {
        this.idMairie = idMairie;
    }

    public String getLibelleMairie() {
        return libelleMairie;
    }

    public void setLibelleMairie(String libelleMairie) {
        this.libelleMairie = libelleMairie;
    }

    public String getQuartierMairie() {
        return quartierMairie;
    }

    public void setQuartierMairie(String quartierMairie) {
        this.quartierMairie = quartierMairie;
    }

    public String getTypeMairie() {
        return typeMairie;
    }

    public void setTypeMairie(String typeMairie) {
        this.typeMairie = typeMairie;
    }

    public Commune getCommune() {
        return commune;
    }

    public void setCommune(Commune commune) {
        this.commune = commune;
    }

    public Collection<Marcher> getMarchers() {
        return marchers;
    }

    public void setMarchers(Collection<Marcher> marchers) {
        this.marchers = marchers;
    }
    public Collection<Utilisateur> getUtilisateurs() {
        return utilisateurs;
    }

    public void setUtilisateurs(Collection<Utilisateur> utilisateurs) {
        this.utilisateurs = utilisateurs;
    }

    @Override
    public String toString() {
        return "Mairie{" +
                "idMairie=" + idMairie +
                ", libelleMairie='" + libelleMairie + '\'' +
                ", quartierMairie='" + quartierMairie + '\'' +
                ", typeMairie='" + typeMairie + '\'' +
                ", commune=" + commune +
                ", marchers=" + marchers +
                ", utilisateurs=" + utilisateurs +
                '}';
    }
}
