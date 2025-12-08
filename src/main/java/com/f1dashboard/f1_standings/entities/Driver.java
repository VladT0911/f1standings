package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Drivers")
public class Driver {
    @Id
    private Long id;
    private String nume;


    private String echipa;
    private long nr_puncte;
    private int nr_victorii;
    private int nr_podiumuri;

    public int getNr_podiumuri() {
        return nr_podiumuri;
    }

    public void setNr_podiumuri(int nr_podiumuri) {
        this.nr_podiumuri = nr_podiumuri;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getEchipa() {
        return echipa;
    }

    public void setEchipa(String echipa) {
        this.echipa = echipa;
    }

    public long getNr_puncte() {
        return nr_puncte;
    }

    public void setNr_puncte(long nr_puncte) {
        this.nr_puncte = nr_puncte;
    }

    public int getNr_victorii() {
        return nr_victorii;
    }

    public void setNr_victorii(int nr_victorii) {
        this.nr_victorii = nr_victorii;
    }

    public Driver() {

    }


    public Driver(String nume, String echipa, long nr_puncte, int nr_victorii, int nr_podiumuri) {
        this.nume = nume;
        this.echipa = echipa;
        this.nr_puncte = nr_puncte;
        this.nr_victorii = nr_victorii;
        this.nr_podiumuri = nr_podiumuri;

    }

    @Override
    public String toString() {
        return "Driver{" +
                "nume='" + nume + '\'' +
                ", echipa=" + echipa +
                ", nr_puncte=" + nr_puncte +
                ", nr_victorii=" + nr_victorii +
                ", first_laps=" + nr_podiumuri +
                '}';
    }
}
