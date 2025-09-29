package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.RendezVous;
import org.esprim.projetlogement.service.RendezVousService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/rendezvous")
public class RendezVousController {
    private final RendezVousService rendezVousService;

    public RendezVousController(RendezVousService rendezVousService) {
        this.rendezVousService = rendezVousService;
    }

    @GetMapping
    public List<RendezVous> getAllRendezVous() {
        return rendezVousService.getAll();
    }

    @PostMapping
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.add(rendezVous);
    }

    @PutMapping
    public RendezVous updateRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.update(rendezVous);
    }

    @DeleteMapping("/{id}")
    public void deleteRendezVous(@PathVariable Integer id) {
        rendezVousService.delete(id);
    }
}