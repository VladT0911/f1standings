package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Echipa;
import com.f1dashboard.f1_standings.repository.EchipeJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class EchipeController {
    private final EchipeJpaRepository repo;

    public EchipeController(EchipeJpaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/echipe")
    public String echipeTeams(Model model) {
        List<Echipa> echipe = repo.findAllByOrderByNrPuncteDesc();
        model.addAttribute("echipe", echipe);
        return "Teams";
    }
}
