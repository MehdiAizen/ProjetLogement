package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Universite;
import org.esprim.projetlogement.service.UniversiteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/universites")
public class UniversiteController {
    private final UniversiteService universiteService;

    public UniversiteController(UniversiteService universiteService) {
        this.universiteService = universiteService;
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteService.getAll();
    }

    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.add(universite);
    }

    @PutMapping
    public Universite updateUniversite(@RequestBody Universite universite) {
        return universiteService.update(universite);
    }

    @DeleteMapping("/{id}")
    public void deleteUniversite(@PathVariable Long id) {
        universiteService.delete(id);
    }
}