package com.slaen.salen.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AffecterPlaceUtilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAffecterPlaceUtilisateur;
    @Temporal(TemporalType.DATE)
    private Date dateAffecterPlaceUtilisateur;

    @ManyToOne
    private Place place;
    @ManyToOne
    private Utilisateur utilisateur;

}
