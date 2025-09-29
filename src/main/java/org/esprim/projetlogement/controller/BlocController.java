package org.esprim.projetlogement.controller;

import org.esprim.projetlogement.entity.Bloc;
import org.esprim.projetlogement.service.BlocService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/blocs")
public class BlocController {
    private final BlocService blocService;

    public BlocController(BlocService blocService) {
        this.blocService = blocService;
    }

    @GetMapping
    public List<Bloc> getAllBlocs() {
        return blocService.getAll();
    }

    @PostMapping
    public Bloc addBloc(@RequestBody Bloc bloc) {
        return blocService.add(bloc);
    }

    @PutMapping
    public Bloc updateBloc(@RequestBody Bloc bloc) {
        return blocService.update(bloc);
    }

    @DeleteMapping("/{id}")
    public void deleteBloc(@PathVariable Long id) {
        blocService.delete(id);
    }
}