package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Echipa;
import com.f1dashboard.f1_standings.repository.EchipeJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class EchipeController {

    private final EchipeJpaRepository repo;

    public EchipeController(EchipeJpaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/teams")
    public String echipeTeams(
            @RequestParam(required = false) String powerunit,
            @RequestParam(required = false) String sort,
            Model model
    ) {
        List<Echipa> echipe;

        if (powerunit != null && !powerunit.isBlank()) {
            if ("principal".equals(sort)) {

                echipe = repo.findByPowerunitIgnoreCaseOrderByTeamPrincipalAsc(powerunit);
            } else {

                echipe = repo.findByPowerunitIgnoreCase(powerunit);
            }
        } else {
            if ("principal".equals(sort)) {

                echipe = repo.findAllByOrderByTeamPrincipalAsc();
            } else {

                echipe = repo.findAllByOrderByNrPuncteDesc();
            }
        }

        model.addAttribute("echipe", echipe);
        model.addAttribute("powerunit", powerunit);

        return "Teams";
    }
}
