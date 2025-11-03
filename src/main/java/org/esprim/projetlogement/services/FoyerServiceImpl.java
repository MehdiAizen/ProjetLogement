package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Foyer;
import org.esprim.projetlogement.repository.FoyerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;

    @Autowired
    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public List<Foyer> getAllFoyers() {
        return foyerRepository.findAll();
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Foyer not found with id: " + id));
    }

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyerById(Long id) {
        if (!foyerRepository.existsById(id)) {
            throw new RuntimeException("Foyer not found with id: " + id);
        }
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        if (foyer.getIdFoyer() == null || !foyerRepository.existsById(foyer.getIdFoyer())) {
            throw new RuntimeException("Cannot update: Foyer not found");
        }
        return foyerRepository.save(foyer);
    }
}