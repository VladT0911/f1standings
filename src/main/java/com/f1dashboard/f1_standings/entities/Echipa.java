package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="Echipe")
public class Echipa {
    @Id
    private Long id;
    private String nume;
    private String powerunit;
    private String Team_principal;
    private int nrPuncte;

    @Override
    public String toString() {
        return "Echipa{" +
                "id=" + id +
                ", nume='" + nume + '\'' +
                ", powerunit='" + powerunit + '\'' +
                ", Team_principal='" + Team_principal + '\'' +
                ", nr_puncte=" + nrPuncte +
                '}';
    }
}
