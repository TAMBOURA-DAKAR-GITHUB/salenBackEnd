package com.slaen.salen.dto;

public class TestPlaceToUser {

    public  String utilisateur;
    public int places[] = new int[]{};

    public String getUtilisateur() {
        int u= Integer.parseInt(utilisateur);
        return utilisateur;
    }

    public void setUtilisateur(String utilisateur) {
        this.utilisateur = utilisateur;
    }

    public int[] getPlace() {
        return places;
    }

    public void setPlace(int[] place) {
        this.places = place;
    }
}
