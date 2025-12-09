package com.f1dashboard.f1_standings.controller;


import com.f1dashboard.f1_standings.entities.Driver;
import com.f1dashboard.f1_standings.repository.DriverJpaRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

public class DriversController {
    private final DriverJpaRepository repo;
    public DriversController(DriverJpaRepository repo)
    {
        this.repo=repo;
    }
    @GetMapping("/drivers")
    public String driversPage(Model model)
    {
        List<Driver>drivers=repo.findAllByOrderByNr_puncteDesc();
        model.addAttribute("drivers",drivers);
        return "drivers";
    }
    @GetMapping("/api/drivers")
    @ResponseBody
    public List<Driver>driversApi()
    {
        return repo.findAllByOrderByNr_puncteDesc();
    }
    @GetMapping("/api/drivers/{id}")
    @ResponseBody
    public Driver getDriver(@PathVariable Long id)
    {
        return repo.findById(id).orElse(null);
    }

}
