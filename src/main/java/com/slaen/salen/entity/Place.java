package com.slaen.salen.entity;

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
    private Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs;
    @OneToMany(mappedBy = "place")
    private Collection<AffecterPlaceMarchand> affecterPlaceMarchands;


}
