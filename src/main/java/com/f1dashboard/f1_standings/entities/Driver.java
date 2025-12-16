package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Drivers")
public class Driver {
    @Id
    private Long id;
    private String nume;


    private String echipa;
    private long nrPuncte;
    private int nrVictorii;
    private int nrPodiumuri;

    public int getNrPodiumuri() {
        return nrPodiumuri;
    }

    public void setNrPodiumuri(int nrPodiumuri) {
        this.nrPodiumuri = nrPodiumuri;
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

    public long getNrPuncte() {
        return nrPuncte;
    }

    public void setNrPuncte(long nrPuncte) {
        this.nrPuncte = nrPuncte;
    }

    public int getNrVictorii() {
        return nrVictorii;
    }

    public void setNrVictorii(int nrVictorii) {
        this.nrVictorii = nrVictorii;
    }

    public Driver() {

    }


    public Driver(String nume, String echipa, long nrPuncte, int nrVictorii, int nrPodiumuri) {
        this.nume = nume;
        this.echipa = echipa;
        this.nrPuncte = nrPuncte;
        this.nrVictorii = nrVictorii;
        this.nrPodiumuri = nrPodiumuri;

    }

    @Override
    public String toString() {
        return "Driver{" +
                "nume='" + nume + '\'' +
                ", echipa=" + echipa +
                ", nr_puncte=" + nrPuncte +
                ", nr_victorii=" + nrVictorii +
                ", first_laps=" + nrPodiumuri +
                '}';
    }
}
