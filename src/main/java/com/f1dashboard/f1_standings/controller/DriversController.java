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
    @PreAuthorize("hasRole('USER')")

    public String driversPage(Model model) {
        model.addAttribute("drivers", repo.findAllByOrderByNrPuncteDesc());
        return "drivers";
    }
    @GetMapping("/api/drivers")
    @ResponseBody
    public List<Driver> allDriversApi() {
        return repo.findAllByOrderByNrPuncteDesc();
    }
    @GetMapping("/api/drivers/top")
    @ResponseBody
    public List<Driver> topDriverApi() {
        return repo.findFirstByOrderByNrPuncteDesc()
                .map(List::of)
                .orElse(List.of());
    }
    @GetMapping("/api/drivers/top3")
    @ResponseBody
    public List<Driver> top3DriversApi() {
        return repo.findTop3ByOrderByNrPuncteDesc();
    }
    @GetMapping("/api/drivers/nrvictorii")
    @ResponseBody
    public List<Driver>DriversNrVictoriiapi()
    {
        return repo.findAllByOrderByNrVictoriiDesc();
    }
    @GetMapping("/api/drivers/min-points")
    @ResponseBody
    public List<Driver> getDriversByMinPoints(@RequestParam long points) {
        return repo.findByNrPuncteGreaterThanEqual(points);
    }
    @GetMapping("/api/drivers/findechipa")
    @ResponseBody
    public List<Driver> findByEchipa(@RequestParam String echipa)
    {
        return repo.findByEchipaIgnoreCase(echipa);
    }
    @GetMapping("/api/drivers/filter")
    @ResponseBody
    public List<Driver> filterDrivers(
            @RequestParam String echipa,
            @RequestParam long points) {
        return repo.findByEchipaAndNrPuncteGreaterThanEqual(echipa, points);
    }



        //
    //List<Driver> findByEchipa(String echipa);

    //  Drivers sorted by wins
    //List<Driver> findAllByOrderByNrVictoriiDesc();

    // Minimum points
    //List<Driver> findByNrPuncteGreaterThanEqual(long points);








}
