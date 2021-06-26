package com.slaen.salen.entity;

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
    private Cercle cercle;
    @OneToMany(mappedBy = "commune")
    private Collection<Mairie> mairies;

}
