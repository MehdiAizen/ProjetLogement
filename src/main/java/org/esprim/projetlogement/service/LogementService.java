package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Logement;
import org.esprim.projetlogement.repository.LogementRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LogementService {
    private final LogementRepository logementRepository;

    public LogementService(LogementRepository logementRepository) {
        this.logementRepository = logementRepository;
    }

    public List<Logement> getAll() {
        return logementRepository.findAll();
    }

    public Logement add(Logement logement) {
        return logementRepository.save(logement);
    }

    public Logement update(Logement logement) {
        return logementRepository.save(logement);
    }

    public void delete(Integer id) {
        logementRepository.deleteById(id);
    }
}