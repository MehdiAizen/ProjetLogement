package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Chambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> getAllChambre();
    Chambre getChambreById(Long id);
    Chambre saveChambre(Chambre chambre);
    void deleteChambreById(Long id);
    Chambre updateChambre(Chambre chambre);
}