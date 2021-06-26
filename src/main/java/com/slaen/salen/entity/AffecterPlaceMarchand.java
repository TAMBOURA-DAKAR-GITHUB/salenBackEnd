package com.slaen.salen.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class AffecterPlaceMarchand implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAffecterPlaceMarchand;
    @Temporal(TemporalType.DATE)
    private Date dateAffecterPlaceMarchand;

    @ManyToOne
    private Marchand marchand;
    @ManyToOne
    private Place place;



}
