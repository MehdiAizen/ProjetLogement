package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Logement;
import org.esprim.projetlogement.service.LogementService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/logements")
public class LogementController {
    private final LogementService logementService;

    public LogementController(LogementService logementService) {
        this.logementService = logementService;
    }

    @GetMapping
    public List<Logement> getAllLogements() {
        return logementService.getAll();
    }

    @PostMapping
    public Logement addLogement(@RequestBody Logement logement) {
        return logementService.add(logement);
    }

    @PutMapping
    public Logement updateLogement(@RequestBody Logement logement) {
        return logementService.update(logement);
    }

    @DeleteMapping("/{id}")
    public void deleteLogement(@PathVariable Integer id) {
        logementService.delete(id);
    }
}
