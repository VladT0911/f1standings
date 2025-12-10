package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Cursa;
import com.f1dashboard.f1_standings.repository.CursaJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CurseController {
    private final CursaJpaRepository repo;

    public CurseController(CursaJpaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/curse")
    public String cursePage(Model model) {
        List<Cursa> curse = repo.findAllByOrderBydataCurseiAsc();
        model.addAttribute("curse", curse);
        return "Races";
    }
}
