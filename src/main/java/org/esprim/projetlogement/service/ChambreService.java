package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.repository.ChambreRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ChambreService {
    private final ChambreRepository chambreRepository;

    public ChambreService(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
    }

    public List<Chambre> getAll() {
        return chambreRepository.findAll();
    }

    public Chambre add(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public Chambre update(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    public void delete(Long id) {
        chambreRepository.deleteById(id);
    }
}