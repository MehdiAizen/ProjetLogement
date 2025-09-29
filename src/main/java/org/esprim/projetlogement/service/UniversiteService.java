package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Universite;
import org.esprim.projetlogement.repository.UniversiteRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteService {
    private final UniversiteRepository universiteRepository;

    public UniversiteService(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    public List<Universite> getAll() {
        return universiteRepository.findAll();
    }

    public Universite add(Universite universite) {
        return universiteRepository.save(universite);
    }

    public Universite update(Universite universite) {
        return universiteRepository.save(universite);
    }

    public void delete(Long id) {
        universiteRepository.deleteById(id);
    }
}