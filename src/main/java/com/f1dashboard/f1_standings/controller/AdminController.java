// src/main/java/com/f1dashboard/f1_standings/controller/AdminController.java
package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.repository.DriverJpaRepository;
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

    public AdminController(DriverJpaRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @PostMapping("/drivers")
    public ResponseEntity<?> addDriver(@RequestBody Driver driver) {
        Driver saved = driverRepository.save(driver);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/drivers/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable Long id, @RequestBody Driver payload) {
        return driverRepository.findById(id)
                .map(d -> {
                    d.setNume(payload.getNume());
                    d.setEchipa(payload.getEchipa());

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
