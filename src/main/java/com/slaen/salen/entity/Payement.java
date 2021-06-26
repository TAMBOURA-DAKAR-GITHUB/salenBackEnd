package com.slaen.salen.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Payement implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idPayement;
    @Temporal(TemporalType.DATE)
    private Date datePayement;
    @NotNull
    private double montantPayement;
    @NotNull
    private double ResteApaye;

    @ManyToOne
    private Marchand marchand;


}
