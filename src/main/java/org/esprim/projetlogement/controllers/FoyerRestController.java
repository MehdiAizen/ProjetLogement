package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Foyer;
import org.esprim.projetlogement.services.IFoyerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foyers")
@Tag(name = "Gestion des Foyers", description = "API CRUD pour la gestion des foyers")
public class FoyerRestController {

    @Autowired
    private IFoyerService foyerService;

    @Operation(summary = "Récupérer tous les foyers")
    @GetMapping
    public List<Foyer> retrieveAllFoyers() {
        return foyerService.getAllFoyers();
    }

    @Operation(summary = "Récupérer un foyer par ID")
    @GetMapping("/{foyerId}")
    public Foyer retrieveFoyerById(@PathVariable Long foyerId) {
        return foyerService.getFoyerById(foyerId);
    }

    @Operation(summary = "Ajouter un nouveau foyer")
    @PostMapping
    public Foyer addFoyer(@RequestBody Foyer foyer) {
        return foyerService.saveFoyer(foyer);
    }

    @Operation(summary = "Supprimer un foyer")
    @DeleteMapping("/{foyerId}")
    public void removeFoyer(@PathVariable Long foyerId) {
        foyerService.deleteFoyerById(foyerId);
    }

    @Operation(summary = "Modifier un foyer")
    @PutMapping
    public Foyer modifyFoyer(@RequestBody Foyer foyer) {
        return foyerService.updateFoyer(foyer);
    }
}