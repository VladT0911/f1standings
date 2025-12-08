package com.f1dashboard.f1_standings.entities;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class Cursa {
    private LocalDate data_cursei;
    private String tara;
    private boolean isSprint;
    private int nr_laps;
}
