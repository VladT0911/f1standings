package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Curse")
public class Cursa {
    @Id
    private long id;
    private LocalDate dataCursei;
    private String tara;
    @Column(name = "is_Sprint")
    private boolean isSprint;
    private int nr_laps;
}
