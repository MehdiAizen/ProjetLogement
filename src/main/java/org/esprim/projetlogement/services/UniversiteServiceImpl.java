package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Universite;
import org.esprim.projetlogement.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {

    private final UniversiteRepository universiteRepository;

    @Autowired
    public UniversiteServiceImpl(UniversiteRepository universiteRepository) {
        this.universiteRepository = universiteRepository;
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Universite not found with id: " + id));
    }

    @Override
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversiteById(Long id) {
        if (!universiteRepository.existsById(id)) {
            throw new RuntimeException("Universite not found with id: " + id);
        }
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        if (universite.getIdUniversite() == null || !universiteRepository.existsById(universite.getIdUniversite())) {
            throw new RuntimeException("Cannot update: Universite not found");
        }
        return universiteRepository.save(universite);
    }
}