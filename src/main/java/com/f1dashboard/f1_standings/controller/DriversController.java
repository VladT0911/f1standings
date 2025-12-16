package com.f1dashboard.f1_standings.controller;


import com.f1dashboard.f1_standings.entities.Driver;
import com.f1dashboard.f1_standings.repository.DriverJpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Optional;

@Controller
public class DriversController {
    private final DriverJpaRepository repo;
    public DriversController(DriverJpaRepository repo)
    {
        this.repo=repo;
    }
    @GetMapping("/drivers")
    public String driversPage(Model model)
    {
        List<Driver>drivers=repo.findAllByOrderByNrPuncteDesc();
        model.addAttribute("drivers",drivers);
        return "Drivers";
    }
    @PreAuthorize("hasRole('USER')")
    @GetMapping("/drivers/top")
    public String getDriverWithMostPoints(Model model) {

        Driver topDriver = repo
                .findFirstByOrderByNrPuncteDesc()
                .orElseThrow(() -> new RuntimeException("No drivers found"));

        model.addAttribute("driver", topDriver);
        return "top-driver";
    }
    @GetMapping("/top3")
    public String top3Drivers(Model model)
    {
        List<Driver>top3Drivers=repo.findTop3ByOrderByNrPuncteDesc();
        model.addAttribute("top3Drivers",top3Drivers);
        return "top3-drivers";
    }
    @GetMapping("/team")
        public String byTeam(@RequestParam String echipa, Model model){
        model.addAttribute("drivers",repo.findByEchipa(echipa));
        return"driver-list";
        }
        @GetMapping("/wins")
        public String byWins(Model model){
        model.addAttribute("drivers",repo.findAllByOrderByNrVictoriiDesc());
        return "driver-list";
        }
        @GetMapping("/filter")
        public String dynamicFilter(
                @RequestParam(required = false) String echipa,
                @RequestParam(required = false) Long minPoints,
                @RequestParam(required = false) String sort,
                Model model){
            List<Driver> drivers;

            if (echipa != null && minPoints != null) {
                drivers = repo
                        .findByEchipaAndNrPuncteGreaterThanEqual(echipa, minPoints);
            } else if (minPoints != null) {
                drivers = repo
                        .findByNrPuncteGreaterThanEqual(minPoints);
            } else {
                drivers = repo.findAll();
            }

            // Manual sorting (dynamic)
            if ("points".equals(sort)) {
                drivers.sort((a, b) -> Long.compare(b.getNrPuncte(), a.getNrPuncte()));
            } else if ("wins".equals(sort)) {
                drivers.sort((a, b) -> Integer.compare(b.getNrVictorii(), a.getNrVictorii()));
            }

            model.addAttribute("drivers", drivers);
            return "driver-list";
        }


    @GetMapping("/api/drivers")
    @ResponseBody
    public List<Driver>driversApi()
    {
        return repo.findAllByOrderByNrPuncteDesc();
    }
    @GetMapping("/api/drivers/{id}")
    @ResponseBody
    public Driver getDriver(@PathVariable Long id)
    {
        return repo.findById(id).orElse(null);
    }

}
