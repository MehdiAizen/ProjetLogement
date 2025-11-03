package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Etudiant;
import org.esprim.projetlogement.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    private final EtudiantRepository etudiantRepository;

    @Autowired
    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return etudiantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Etudiant not found with id: " + id));
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiantById(Long id) {
        if (!etudiantRepository.existsById(id)) {
            throw new RuntimeException("Etudiant not found with id: " + id);
        }
        etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        if (etudiant.getIdEtudiant() == null || !etudiantRepository.existsById(etudiant.getIdEtudiant())) {
            throw new RuntimeException("Cannot update: Etudiant not found");
        }
        return etudiantRepository.save(etudiant);
    }
}