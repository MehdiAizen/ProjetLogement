package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Etudiant;
import org.esprim.projetlogement.repository.EtudiantRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantService {
    private final EtudiantRepository etudiantRepository;

    public EtudiantService(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public List<Etudiant> getAll() {
        return etudiantRepository.findAll();
    }

    public Etudiant add(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public Etudiant update(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    public void delete(Long id) {
        etudiantRepository.deleteById(id);
    }
}