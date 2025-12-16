package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Curse")
public class Cursa {
    @Id
    private long id;
    private LocalDate dataCursei;
    private String tara;
    @Column(name = "isSprint")
    private boolean isSprint;
    @Column(name = "nrLaps")
    private int nrLaps;
}
