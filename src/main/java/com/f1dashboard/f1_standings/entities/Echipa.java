package com.f1dashboard.f1_standings.entities;

public class Echipa {
    private String nume;
    private String powerunit;
    private String Team_principal;
    private int nr_puncte;

    public String getPowerunit() {
        return powerunit;
    }

    public void setPowerunit(String powerunit) {
        this.powerunit = powerunit;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getTeam_principal() {
        return Team_principal;
    }

    public void setTeam_principal(String team_principal) {
        Team_principal = team_principal;
    }

    public int getNr_puncte() {
        return nr_puncte;
    }

    public void setNr_puncte(int nr_puncte) {
        this.nr_puncte = nr_puncte;
    }

    public Echipa(String nume, String powerunit, String team_principal, int nr_puncte) {
        this.nume = nume;
        this.powerunit = powerunit;
        Team_principal = team_principal;
        this.nr_puncte = nr_puncte;
    }

    @Override
    public String toString() {
        return "Echipa{" +
                "nume='" + nume + '\'' +
                ", powerunit='" + powerunit + '\'' +
                ", Team_principal='" + Team_principal + '\'' +
                ", nr_puncte=" + nr_puncte +
                '}';
    }
}
