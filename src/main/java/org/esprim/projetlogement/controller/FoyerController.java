package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Foyer;
import org.esprim.projetlogement.service.FoyerService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/foyers")
public class FoyerController {
    private final FoyerService foyerService;

    public FoyerController(FoyerService foyerService) {
        this.foyerService = foyerService;
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerService.getAll();
    }

    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.add(foyer);
    }

    @PutMapping
    public Foyer updateFoyer(@RequestBody Foyer foyer) {
        return foyerService.update(foyer);
    }

    @DeleteMapping("/{id}")
    public void deleteFoyer(@PathVariable Long id) {
        foyerService.delete(id);
    }
}