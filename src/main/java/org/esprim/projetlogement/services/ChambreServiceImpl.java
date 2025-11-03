package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.repository.ChambreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChambreServiceImpl implements IChambreService {

    private final ChambreRepository chambreRepository;

    @Autowired
    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    @Override
    public List<Chambre> getAllChambre() {
        return chambreRepository.findAll();
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Chambre not found with id: " + id));
    }

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambreById(Long id) {
        if (!chambreRepository.existsById(id)) {
            throw new RuntimeException("Chambre not found with id: " + id);
        }
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        if (chambre.getIdChambre() == null || !chambreRepository.existsById(chambre.getIdChambre())) {
            throw new RuntimeException("Cannot update: Chambre not found");
        }
        return chambreRepository.save(chambre);
    }
}