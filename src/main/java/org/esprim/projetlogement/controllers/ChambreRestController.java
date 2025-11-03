package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chambres")
@Tag(name = "Gestion des Chambres", description = "API CRUD pour la gestion des chambres")
public class ChambreRestController {

    @Autowired
    private IChambreService chambreService;

    @Operation(summary = "Récupérer toutes les chambres")
    @GetMapping
    public List<Chambre> retrieveAllChambres() {
        return chambreService.getAllChambre();
    }

    @Operation(summary = "Récupérer une chambre par ID")
    @GetMapping("/{chambreId}")
    public Chambre retrieveChambreById(@PathVariable Long chambreId) {
        return chambreService.getChambreById(chambreId);
    }

    @Operation(summary = "Ajouter une nouvelle chambre")
    @PostMapping
    public Chambre addChambre(@RequestBody Chambre chambre) {
        return chambreService.saveChambre(chambre);
    }

    @Operation(summary = "Supprimer une chambre")
    @DeleteMapping("/{chambreId}")
    public void removeChambre(@PathVariable Long chambreId) {
        chambreService.deleteChambreById(chambreId);
    }

    @Operation(summary = "Modifier une chambre")
    @PutMapping
    public Chambre modifyChambre(@RequestBody Chambre chambre) {
        return chambreService.updateChambre(chambre);
    }
}