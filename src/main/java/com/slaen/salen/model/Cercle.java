package com.slaen.salen.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Cercle implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCercle;
    @Column(length = 50)
    @NotNull
    private String libelleCercle;

    @OneToMany(mappedBy = "cercle")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Commune> communes;
    @ManyToOne
    @JoinColumn(name = "idRegion")
    private Region region;

    public Cercle() {
    }

    public Cercle(String libelleCercle, Region region) {
        this.libelleCercle = libelleCercle;
        this.region = region;
    }

    public long getIdCercle() {
        return idCercle;
    }

    public void setIdCercle(long idCercle) {
        this.idCercle = idCercle;
    }

    public String getLibelleCercle() {
        return libelleCercle;
    }

    public void setLibelleCercle(String libelleCercle) {
        this.libelleCercle = libelleCercle;
    }

    public Collection<Commune> getCommunes() {
        return communes;
    }

    public void setCommunes(Collection<Commune> communes) {
        this.communes = communes;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    @Override
    public String toString() {
        return "Cercle{" +
                "idCercle=" + idCercle +
                ", libelleCercle='" + libelleCercle + '\'' +
                ", communes=" + communes +
                ", region=" + region +
                '}';
    }
}
