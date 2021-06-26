package com.slaen.salen.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

@Entity
public class Marchand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idMarchand;
    @Column(length = 50)
    @NotNull
    private String nomMarchand;
    @Column(length = 50)
    @NotNull
    private String prenomMarchand;
    @Temporal(TemporalType.DATE)
    private Date dateOccupationMarchand;
    @Column(length = 50)
    @NotNull
    private String telephoneMarchand;

    @OneToMany(mappedBy = "marchand")
    private Collection<AffecterPlaceMarchand> affecterPlaceMarchands;
    @OneToMany(mappedBy = "marchand")
    private Collection<Payement> payements;

}
