package com.slaen.salen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Marcher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMarcher;
    @Column(length = 50)
    private String libelleMarcher;

    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Mairie mairie;

    @OneToMany(mappedBy = "marcher")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<Place> places;

    public Marcher() {
    }

    public Marcher(String libelleMarcher, Mairie mairie) {
        this.libelleMarcher = libelleMarcher;
        this.mairie = mairie;
    }

    public long getIdMarcher() {
        return idMarcher;
    }

    public void setIdMarcher(long idMarcher) {
        this.idMarcher = idMarcher;
    }

    public String getLibelleMarcher() {
        return libelleMarcher;
    }

    public void setLibelleMarcher(String libelleMarcher) {
        this.libelleMarcher = libelleMarcher;
    }

    public Mairie getMairie() {
        return mairie;
    }

    public void setMairie(Mairie mairie) {
        this.mairie = mairie;
    }

    public Collection<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Collection<Place> places) {
        this.places = places;
    }

    @Override
    public String toString() {
        return "Marcher{" +
                "idMarcher=" + idMarcher +
                ", libelleMarcher='" + libelleMarcher + '\'' +
                ", mairie=" + mairie +
                ", places=" + places +
                '}';
    }
}
