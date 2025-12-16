package com.f1dashboard.f1_standings.entities;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Entity
@Table(name = "Drivers")
public class Driver {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nume;


    private String echipa;
    private long nrPuncte;
    private int nrVictorii;
    private int nrPodiumuri;


}
