package org.esprim.projetlogement.controllers;

import org.esprim.projetlogement.entity.Bloc;
import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.entity.TypeChambre;
import org.esprim.projetlogement.services.IBlocService;
import org.esprim.projetlogement.services.IChambreService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/blocs")
@Tag(name = "Gestion des Blocs", description = "API CRUD pour la gestion des blocs")
public class BlocRestController {

    @Autowired
    private IBlocService blocService;

    @Autowired
    private IChambreService chambreService;

    @Operation(summary = "Récupérer tous les blocs")
    @GetMapping
    public List<Bloc> retrieveAllBlocs() {
        return blocService.getAllBlocs();
    }

    @Operation(summary = "Récupérer un bloc par ID")
    @GetMapping("/{blocId}")
    public Bloc retrieveBlocById(@PathVariable Long blocId) {
        return blocService.getBlocById(blocId);
    }

    @Operation(summary = "Ajouter un nouveau bloc")
    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.saveBloc(bloc);
    }

    @Operation(summary = "Supprimer un bloc")
    @DeleteMapping("/{blocId}")
    public void removeBloc(@PathVariable Long blocId) {
        blocService.deleteBlocById(blocId);
    }

    @Operation(summary = "Modifier un bloc")
    @PutMapping
    public Bloc modifyBloc(@RequestBody Bloc bloc) {
        return blocService.updateBloc(bloc);
    }

    @Operation(summary = "Récupérer les chambres par bloc et type")
    @GetMapping("/{blocId}/chambres/type/{type}")
    public List<Chambre> getChambresByBlocAndType(@PathVariable Long blocId, @PathVariable TypeChambre type) {
        return chambreService.findByBlocIdBlocAndTypeChambre(blocId, type);
    }
}