package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Etudiant;
import org.esprim.projetlogement.services.IEtudiantService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/etudiants")
@Tag(name = "Gestion des Étudiants", description = "API CRUD pour la gestion des étudiants")
public class EtudiantRestController {

    @Autowired
    private IEtudiantService etudiantService;

    @Operation(summary = "Récupérer tous les étudiants")
    @GetMapping
    public List<Etudiant> retrieveAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @Operation(summary = "Récupérer un étudiant par ID")
    @GetMapping("/{etudiantId}")
    public Etudiant retrieveEtudiantById(@PathVariable Long etudiantId) {
        return etudiantService.getEtudiantById(etudiantId);
    }

    @Operation(summary = "Ajouter un nouvel étudiant")
    @PostMapping
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    @Operation(summary = "Supprimer un étudiant")
    @DeleteMapping("/{etudiantId}")
    public void removeEtudiant(@PathVariable Long etudiantId) {
        etudiantService.deleteEtudiantById(etudiantId);
    }

    @Operation(summary = "Modifier un étudiant")
    @PutMapping
    public Etudiant modifyEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.updateEtudiant(etudiant);
    }
}