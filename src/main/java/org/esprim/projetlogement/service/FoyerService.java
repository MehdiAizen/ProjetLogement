package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Foyer;
import org.esprim.projetlogement.repository.FoyerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoyerService {
    private final FoyerRepository foyerRepository;

    public FoyerService(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    public List<Foyer> getAll() {
        return foyerRepository.findAll();
    }

    public Foyer add(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public Foyer update(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    public void delete(Long id) {
        foyerRepository.deleteById(id);
    }
}