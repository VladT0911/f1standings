package com.f1dashboard.f1_standings.entities;

public class Driver {
    private String nume;
    private Echipa echipa;
    private long nr_puncte;
    private int nr_victorii;
    private int first_laps;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public Echipa getEchipa() {
        return echipa;
    }

    public void setEchipa(Echipa echipa) {
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

    public int getFirst_laps() {
        return first_laps;
    }

    public void setFirst_laps(int first_laps) {
        this.first_laps = first_laps;
    }

    public Driver(String nume, Echipa echipa, long nr_puncte, int nr_victorii, int first_laps) {
        this.nume = nume;
        this.echipa = echipa;
        this.nr_puncte = nr_puncte;
        this.nr_victorii = nr_victorii;
        this.first_laps = first_laps;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "nume='" + nume + '\'' +
                ", echipa=" + echipa +
                ", nr_puncte=" + nr_puncte +
                ", nr_victorii=" + nr_victorii +
                ", first_laps=" + first_laps +
                '}';
    }
}
