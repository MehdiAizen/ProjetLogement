package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Etudiant;
import org.esprim.projetlogement.service.EtudiantService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantController {
    private final EtudiantService etudiantService;

    public EtudiantController(EtudiantService etudiantService) {
        this.etudiantService = etudiantService;
    }

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAll();
    }

    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.add(etudiant);
    }

    @PutMapping
    public Etudiant updateEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.update(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.delete(id);
    }
}