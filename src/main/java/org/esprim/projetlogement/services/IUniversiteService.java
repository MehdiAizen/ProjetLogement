package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Universite;
import java.util.List;

public interface IUniversiteService {
    List<Universite> getAllUniversites();
    Universite getUniversiteById(Long id);
    Universite saveUniversite(Universite universite);
    void deleteUniversiteById(Long id);
    Universite updateUniversite(Universite universite);
}