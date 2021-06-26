package com.slaen.salen.entity;

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
    private Collection<Commune> communes;
    @ManyToOne
    private Region region;



}
