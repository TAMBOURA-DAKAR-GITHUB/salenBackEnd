package com.slaen.salen.entity;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Utilisateur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtilisateur;
    @Column(length = 50)
    @NotNull
    private String nomUtilisateur;
    @Column(length = 50)
    @NotNull
    private String prenomUtilisateur;
    @Column(length = 50)
    @NotNull
    private String adresseUtilisateur;
    @Column(length = 50)
    @NotNull
    private String codeUtilisateur;
    @Column(length = 50)
    @NotNull
    private String telephoneUtilisateur;
    @Column(length = 50)
    @NotNull
    private String emailUtilisateur;

    @OneToMany(mappedBy = "utilisateur")
    private Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs;

}
