package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Universite;
import org.esprim.projetlogement.services.IUniversiteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/universites")
@Tag(name = "Gestion des Universités", description = "API CRUD pour la gestion des universités")
public class UniversiteRestController {

    @Autowired
    private IUniversiteService universiteService;

    @Operation(summary = "Récupérer toutes les universités")
    @GetMapping
    public List<Universite> retrieveAllUniversites() {
        return universiteService.getAllUniversites();
    }

    @Operation(summary = "Récupérer une université par ID")
    @GetMapping("/{universiteId}")
    public Universite retrieveUniversiteById(@PathVariable Long universiteId) {
        return universiteService.getUniversiteById(universiteId);
    }

    @Operation(summary = "Ajouter une nouvelle université")
    @PostMapping
    public Universite addUniversite(@RequestBody Universite universite) {
        return universiteService.saveUniversite(universite);
    }

    @Operation(summary = "Supprimer une université")
    @DeleteMapping("/{universiteId}")
    public void removeUniversite(@PathVariable Long universiteId) {
        universiteService.deleteUniversiteById(universiteId);
    }

    @Operation(summary = "Modifier une université")
    @PutMapping
    public Universite modifyUniversite(@RequestBody Universite universite) {
        return universiteService.updateUniversite(universite);
    }
}