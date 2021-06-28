package com.slaen.salen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Commune implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCommune;
    @Column(length = 50)
    @NotNull
    private String libelleCommune;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Cercle cercle;
    @OneToMany(mappedBy = "commune")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Mairie> mairies;

    public Commune() {
    }

    public Commune(String libelleCommune, Cercle cercle) {
        this.libelleCommune = libelleCommune;
        this.cercle = cercle;
    }

    public long getIdCommune() {
        return idCommune;
    }

    public void setIdCommune(long idCommune) {
        this.idCommune = idCommune;
    }

    public String getLibelleCommune() {
        return libelleCommune;
    }

    public void setLibelleCommune(String libelleCommune) {
        this.libelleCommune = libelleCommune;
    }

    public Cercle getCercle() {
        return cercle;
    }

    public void setCercle(Cercle cercle) {
        this.cercle = cercle;
    }

    public Collection<Mairie> getMairies() {
        return mairies;
    }

    public void setMairies(Collection<Mairie> mairies) {
        this.mairies = mairies;
    }

    @Override
    public String toString() {
        return "Commune{" +
                "idCommune=" + idCommune +
                ", libelleCommune='" + libelleCommune + '\'' +
                ", cercle=" + cercle +
                ", mairies=" + mairies +
                '}';
    }
}
