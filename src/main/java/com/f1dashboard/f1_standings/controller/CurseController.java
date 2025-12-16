package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Cursa;
import com.f1dashboard.f1_standings.repository.CursaJpaRepository;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class CurseController {

    private final CursaJpaRepository cursaRepository;

    public CurseController(CursaJpaRepository cursaRepository) {
        this.cursaRepository = cursaRepository;
    }

    @GetMapping("/races")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public String racesPage(Model model) {
        List<Cursa> curse = cursaRepository.findAllByOrderByDataCurseiAsc();
        model.addAttribute("curse", curse);
        return "races";
    }

    @GetMapping("/races/filter")
    @ResponseBody
    public List<Cursa> filterRaces(@RequestParam boolean sprint) {
        return cursaRepository.findByIsSprint(sprint);
    }

    @GetMapping("/races/order-by-laps")
    @ResponseBody
    public List<Cursa> orderByLaps(@RequestParam(required = false) Boolean sprint) {
        if (sprint == null) {
            return cursaRepository.findAllByOrderByNrLapsDesc();
        }
        return cursaRepository.findByIsSprintOrderByNrLapsDesc(sprint);
    }


}
