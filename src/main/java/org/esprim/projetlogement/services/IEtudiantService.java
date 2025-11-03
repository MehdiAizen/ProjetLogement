package org.esprim.projetlogement.services;

import org.esprim.projetlogement.entity.Etudiant;
import java.util.List;

public interface IEtudiantService {
    List<Etudiant> getAllEtudiants();
    Etudiant getEtudiantById(Long id);
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiantById(Long id);
    Etudiant updateEtudiant(Etudiant etudiant);
}