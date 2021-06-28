package com.slaen.salen.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @ManyToOne
    private Mairie mairie;

    @OneToMany(mappedBy = "utilisateur")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs;

    public Utilisateur() {
    }

    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String adresseUtilisateur, String codeUtilisateur, String telephoneUtilisateur, String emailUtilisateur , Mairie mairie) {
        this.nomUtilisateur = nomUtilisateur;
        this.prenomUtilisateur = prenomUtilisateur;
        this.adresseUtilisateur = adresseUtilisateur;
        this.codeUtilisateur = codeUtilisateur;
        this.telephoneUtilisateur = telephoneUtilisateur;
        this.emailUtilisateur = emailUtilisateur;
        this.mairie= mairie;
    }

    public long getIdUtilisateur() {
        return idUtilisateur;
    }

    public void setIdUtilisateur(long idUtilisateur) {
        this.idUtilisateur = idUtilisateur;
    }

    public String getNomUtilisateur() {
        return nomUtilisateur;
    }

    public void setNomUtilisateur(String nomUtilisateur) {
        this.nomUtilisateur = nomUtilisateur;
    }

    public String getPrenomUtilisateur() {
        return prenomUtilisateur;
    }

    public void setPrenomUtilisateur(String prenomUtilisateur) {
        this.prenomUtilisateur = prenomUtilisateur;
    }

    public String getAdresseUtilisateur() {
        return adresseUtilisateur;
    }

    public void setAdresseUtilisateur(String adresseUtilisateur) {
        this.adresseUtilisateur = adresseUtilisateur;
    }

    public String getCodeUtilisateur() {
        return codeUtilisateur;
    }

    public void setCodeUtilisateur(String codeUtilisateur) {
        this.codeUtilisateur = codeUtilisateur;
    }

    public String getTelephoneUtilisateur() {
        return telephoneUtilisateur;
    }

    public void setTelephoneUtilisateur(String telephoneUtilisateur) {
        this.telephoneUtilisateur = telephoneUtilisateur;
    }

    public String getEmailUtilisateur() {
        return emailUtilisateur;
    }

    public void setEmailUtilisateur(String emailUtilisateur) {
        this.emailUtilisateur = emailUtilisateur;
    }

    public Collection<AffecterPlaceUtilisateur> getAffecterPlaceUtilisateurs() {
        return affecterPlaceUtilisateurs;
    }

    public void setAffecterPlaceUtilisateurs(Collection<AffecterPlaceUtilisateur> affecterPlaceUtilisateurs) {
        this.affecterPlaceUtilisateurs = affecterPlaceUtilisateurs;
    }

    public Mairie getMairie() {
        return mairie;
    }

    public void setMairie(Mairie mairie) {
        this.mairie = mairie;
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "idUtilisateur=" + idUtilisateur +
                ", nomUtilisateur='" + nomUtilisateur + '\'' +
                ", prenomUtilisateur='" + prenomUtilisateur + '\'' +
                ", adresseUtilisateur='" + adresseUtilisateur + '\'' +
                ", codeUtilisateur='" + codeUtilisateur + '\'' +
                ", telephoneUtilisateur='" + telephoneUtilisateur + '\'' +
                ", emailUtilisateur='" + emailUtilisateur + '\'' +
                ", mairie=" + mairie +
                ", affecterPlaceUtilisateurs=" + affecterPlaceUtilisateurs +
                '}';
    }
}
