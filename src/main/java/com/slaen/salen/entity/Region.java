package com.slaen.salen.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Region implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idRegion;
    @Column(length = 50)
    @NotNull
    private String libelleRegion;
    @OneToMany(mappedBy = "region")
    private Collection<Cercle> cercles;



}
