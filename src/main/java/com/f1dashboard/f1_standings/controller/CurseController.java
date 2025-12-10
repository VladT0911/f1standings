package com.f1dashboard.f1_standings.controller;

import com.f1dashboard.f1_standings.entities.Cursa;
import com.f1dashboard.f1_standings.repository.CursaJpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CurseController {
    private final CursaJpaRepository repo;

    public CurseController(CursaJpaRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/curse")
    public String cursePage(Model model) {
        List<Cursa> curse = repo.findAllByOrderByDataCurseiAsc();
        model.addAttribute("curse", curse);
        return "Races";
    }

    @GetMapping("/api/races")
    @ResponseBody
    public List<RaceEvent> racesApi() {
        return repo.findAllByOrderByDataCurseiAsc().stream()
                .map(cursa -> new RaceEvent(
                        cursa.getId(),
                        cursa.getTara(),
                        cursa.getDataCursei().toString(),
                        cursa.isSprint() ? "Sprint" : "Race"
                ))
                .collect(Collectors.toList());
    }

    public static class RaceEvent {
        public long id;
        public String title;
        public String start;
        public String type;

        public RaceEvent(long id, String title, String start, String type) {
            this.id = id;
            this.title = title;
            this.start = start;
            this.type = type;
        }
    }
}
