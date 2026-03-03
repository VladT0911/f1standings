// src/main/java/com/f1dashboard/f1_standings/controller/AdminController.java
package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Echipa;
import com.f1dashboard.f1_standings.repository.DriverJpaRepository;
import com.f1dashboard.f1_standings.repository.EchipeJpaRepository;
import org.apache.coyote.Request;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

// Replace these imports with your actual entity/repository packages
import com.f1dashboard.f1_standings.entities.Driver;
import com.f1dashboard.f1_standings.repository.DriverJpaRepository;

@RestController
@RequestMapping("/admin")
@PreAuthorize("hasRole('ADMIN')")
public class AdminController {

    private final DriverJpaRepository driverRepository;
    private final EchipeJpaRepository echipeRepository;


    public AdminController(DriverJpaRepository driverRepository,EchipeJpaRepository echipeRepository) {
        this.driverRepository = driverRepository;
        this.echipeRepository=echipeRepository;
    }
    @PostMapping("/Teams")
    public ResponseEntity<?>addTeam(@RequestBody Echipa echipa)
    {
        Echipa saved=echipeRepository.save(echipa);
        return ResponseEntity.ok(saved);
    }

    @PostMapping("/drivers")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver) {
        Driver saved = driverRepository.save(driver);
        return ResponseEntity.ok(saved);
    }
    /*@PutMapping("/Teams/{id}")
    public ResponseEntity<?> updateTeam(@PathVariable Long id, RequestBody Echipa )
    {

    }*/

    @PutMapping("/drivers/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Long id, @RequestBody Driver payload) {
        return driverRepository.findById(id)
                .map(d -> {
                    d.setNume(payload.getNume());
                    d.setEchipa(payload.getEchipa());
                    d.setNrPuncte(payload.getNrPuncte());
                    d.setNrVictorii(payload.getNrVictorii());
                    d.setNrPodiumuri(payload.getNrPodiumuri());


                    driverRepository.save(d);
                    return ResponseEntity.ok(d);
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/drivers/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable Long id) {
        if (!driverRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        driverRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
