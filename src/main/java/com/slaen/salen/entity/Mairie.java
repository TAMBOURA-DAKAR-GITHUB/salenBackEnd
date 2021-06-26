package com.slaen.salen.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
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

    private String typeMairie;

    @ManyToOne
    private Commune commune;
    @OneToMany(mappedBy = "mairie")
    private Collection<Marcher> marchers;

}
