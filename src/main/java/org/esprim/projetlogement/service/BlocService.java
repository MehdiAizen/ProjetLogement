package org.esprim.projetlogement.service;

import org.esprim.projetlogement.entity.Bloc;
import org.esprim.projetlogement.repository.BlocRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlocService {
    private final BlocRepository blocRepository;

    public BlocService(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
    }

    public List<Bloc> getAll() {
        return blocRepository.findAll();
    }

    public Bloc add(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public Bloc update(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    public void delete(Long id) {
        blocRepository.deleteById(id);
    }
}