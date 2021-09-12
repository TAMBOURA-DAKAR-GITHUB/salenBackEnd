package com.slaen.salen.dto;

import java.util.Date;

public class Facture {

    private long idmarchand;
    private long idutilisateur;
    private Date datefacture;

    public long getIdmarchand() {
        return idmarchand;
    }

    public void setIdmarchand(long idmarchand) {
        this.idmarchand = idmarchand;
    }

    public long getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(long idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Date getDatefacture() {
        return datefacture;
    }

    public void setDatefacture(Date datefacture) {
        this.datefacture = datefacture;
    }
}
