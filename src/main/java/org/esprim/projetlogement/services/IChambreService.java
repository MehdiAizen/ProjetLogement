package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Chambre;
import org.esprim.projetlogement.entity.TypeChambre;
import java.util.List;

public interface IChambreService {
    List<Chambre> getAllChambre();
    Chambre getChambreById(Long id);
    Chambre saveChambre(Chambre chambre);
    void deleteChambreById(Long id);
    Chambre updateChambre(Chambre chambre);

    // Méthodes supplémentaires pour les requêtes personnalisées
    List<Chambre> findChambresParNomUniversite(String nomUniversite);
    List<Chambre> findChambresParBlocEtTypeJPQL(Long idBloc, TypeChambre type);
    List<Chambre> findByBlocIdBlocAndTypeChambre(Long idBloc, TypeChambre typeChambre);
    List<Chambre> findChambresNonReserveesParNomUnivEtType(String nomUniversite, TypeChambre type);
    List<Chambre> findChambresNonReservees();
}