package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.service.ChambreService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/chambres")
public class ChambreController {
    private final ChambreService chambreService;

    public ChambreController(ChambreService chambreService) {
        this.chambreService = chambreService;
    }

    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreService.getAll();
    }

    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.add(chambre);
    }

    @PutMapping
    public Chambre updateChambre(@RequestBody Chambre chambre) {
        return chambreService.update(chambre);
    }

    @DeleteMapping("/{id}")
    public void deleteChambre(@PathVariable Long id) {
        chambreService.delete(id);
    }
}