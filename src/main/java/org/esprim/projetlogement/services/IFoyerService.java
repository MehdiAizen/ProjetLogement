package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Foyer;
import java.util.List;

public interface IFoyerService {
    List<Foyer> getAllFoyers();
    Foyer getFoyerById(Long id);
    Foyer saveFoyer(Foyer foyer);
    void deleteFoyerById(Long id);
    Foyer updateFoyer(Foyer foyer);
}