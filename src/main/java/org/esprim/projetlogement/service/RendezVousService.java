package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.RendezVous;
import org.esprim.projetlogement.repository.RendezVousRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RendezVousService {
    private final RendezVousRepository rendezVousRepository;

    public RendezVousService(RendezVousRepository rendezVousRepository) {
        this.rendezVousRepository = rendezVousRepository;
    }

    public List<RendezVous> getAll() {
        return rendezVousRepository.findAll();
    }

    public RendezVous add(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public RendezVous update(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    public void delete(Integer id) {
        rendezVousRepository.deleteById(id);
    }
}