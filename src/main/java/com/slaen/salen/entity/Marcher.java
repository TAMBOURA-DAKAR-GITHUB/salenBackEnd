package com.slaen.salen.entity;

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
    private Mairie mairie;
    @OneToMany(mappedBy = "marcher")
    private Collection<Place> places;

}
